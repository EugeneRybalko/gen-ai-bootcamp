package com.epam.training.gen.ai.service;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.azure.ai.openai.models.EmbeddingItem;
import com.azure.ai.openai.models.Embeddings;
import com.azure.ai.openai.models.EmbeddingsOptions;
import io.qdrant.client.QdrantClient;
import io.qdrant.client.grpc.Points;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static io.qdrant.client.PointIdFactory.id;
import static io.qdrant.client.ValueFactory.value;
import static io.qdrant.client.VectorsFactory.vectors;
import static io.qdrant.client.WithPayloadSelectorFactory.enable;

@Service
@Slf4j
@AllArgsConstructor
public class EmbeddingService {

    private static final String COLLECTION_NAME = "embedding_collection";
    private final OpenAIAsyncClient openAIAsyncClient;
    private final QdrantClient qdrantClient;


    /**
     * Processes the input text into embeddings, transforms them into vector points,
     * and saves them in the Qdrant collection.
     *
     * @param text the text to be processed into embeddings
     * @throws ExecutionException if the vector saving operation fails
     * @throws InterruptedException if the thread is interrupted during execution
     */
    public void processAndSaveText(String text) throws ExecutionException, InterruptedException {
        var embeddings = getEmbeddings(text);
        var points = new ArrayList<List<Float>>();
        embeddings.forEach(
                embeddingItem -> {
                    var values = new ArrayList<>(embeddingItem.getEmbedding());
                    points.add(values);
                });

        var pointStructs = new ArrayList<Points.PointStruct>();
        points.forEach(point -> {
            var pointStruct = getPointStruct(point, text);
            pointStructs.add(pointStruct);
        });

        saveVector(pointStructs);
    }

    /**
     * Searches the Qdrant collection for vectors similar to the input text.
     * <p>
     * The input text is converted to embeddings, and a search is performed based on the vector similarity.
     *
     * @param text the text to search for similar vectors
     * @return a list of scored points representing similar vectors
     * @throws ExecutionException if the search operation fails
     * @throws InterruptedException if the thread is interrupted during execution
     */
    public List<Points.ScoredPoint> search(String text) throws ExecutionException, InterruptedException {
        var embeddings = retrieveEmbeddings(text);
        var qe = new ArrayList<Float>();
        embeddings.block().getData().forEach(embeddingItem ->
                qe.addAll(embeddingItem.getEmbedding())
        );
        return qdrantClient
                .searchAsync(
                        Points.SearchPoints.newBuilder()
                                .setCollectionName(COLLECTION_NAME)
                                .addAllVector(qe)
                                .setWithPayload(enable(true))
                                .setLimit(1)
                                .build())
                .get();
    }


    /**
     * Retrieves the embeddings for the given text using Azure OpenAI.
     *
     * @param text the text to be embedded
     * @return a list of {@link EmbeddingItem} representing the embeddings
     */
    public List<EmbeddingItem> getEmbeddings(String text) {
        var embeddings = retrieveEmbeddings(text);
        return embeddings.block().getData();
    }

    /**
     * Retrieves the embeddings for the given text asynchronously from Azure OpenAI.
     *
     * @param text the text to be embedded
     * @return a {@link Mono} of {@link Embeddings} representing the embeddings
     */
    private Mono<Embeddings> retrieveEmbeddings(String text) {
        var qembeddingsOptions = new EmbeddingsOptions(List.of(text));
        return openAIAsyncClient.getEmbeddings("text-embedding-ada-002", qembeddingsOptions);
    }

    /**
     * Constructs a point structure from a list of float values representing a vector.
     *
     * @param point the vector values
     * @return a {@link Points.PointStruct} object containing the vector and associated metadata
     */
    private Points.PointStruct getPointStruct(List<Float> point, String originalText) {
        return Points.PointStruct.newBuilder()
                .setId(id(UUID.randomUUID()))
                .setVectors(vectors(point))
                .putAllPayload(Map.of("info", value(originalText)))
                .build();
    }

    /**
     * Saves the list of point structures (vectors) to the Qdrant collection.
     *
     * @param pointStructs the list of vectors to be saved
     * @throws InterruptedException if the thread is interrupted during execution
     * @throws ExecutionException if the saving operation fails
     */
    private void saveVector(ArrayList<Points.PointStruct> pointStructs) throws InterruptedException, ExecutionException {
        var updateResult = qdrantClient.upsertAsync(COLLECTION_NAME, pointStructs).get();
        log.info(updateResult.getStatus().name());
    }


}
