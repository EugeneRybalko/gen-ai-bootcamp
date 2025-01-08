package com.epam.training.gen.ai.controller;

import com.azure.ai.openai.models.EmbeddingItem;
import com.epam.training.gen.ai.model.EmbeddingRequest;
import com.epam.training.gen.ai.model.EmbeddingResponse;
import com.epam.training.gen.ai.model.Prompt;
import com.epam.training.gen.ai.model.PromptResponse;
import com.epam.training.gen.ai.service.EmbeddingService;
import com.epam.training.gen.ai.service.KernelService;
import com.epam.training.gen.ai.service.PromptService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class GenAIController {

    private final PromptService service;
    private final KernelService kernelService;
    private final EmbeddingService embeddingService;

    @PostMapping("/ai/semantic")
    public PromptResponse callSemanticKernel(@RequestBody Prompt request) {
        var messages = kernelService.processWithHistory(request);
        return new PromptResponse(List.of(messages));
    }

    @PostMapping("/ai/direct/open-ai")
    public PromptResponse callOpenAI(@RequestBody Prompt request) {
        var messages = service.getChatCompletions(request);
        return new PromptResponse(messages);
    }

    @SneakyThrows
    @PostMapping("/embedding")
    public void createAndSaveEmbedding(@RequestBody EmbeddingRequest request) {
        embeddingService.processAndSaveText(request.text());
    }

    @SneakyThrows
    @PostMapping("/embedding/testGeneration")
    public List<EmbeddingItem> createEmbedding(@RequestBody EmbeddingRequest request) {
        return embeddingService.getEmbeddings(request.text());
    }

    @SneakyThrows
    @PostMapping("/embedding/search")
    public EmbeddingResponse getEmbedding(@RequestBody EmbeddingRequest request) {
        var points = embeddingService.search(request.text());
        log.info("Points: {}", points);
        return points.stream()
                .map(scoredPoint ->
                        new EmbeddingResponse(scoredPoint.getPayloadMap().get("info").getStringValue(),
                                scoredPoint.getScore())).findFirst().get();
    }
}
