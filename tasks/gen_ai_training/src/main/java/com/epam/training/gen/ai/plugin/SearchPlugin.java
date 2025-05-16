package com.epam.training.gen.ai.plugin;

import com.epam.training.gen.ai.service.EmbeddingService;
import com.microsoft.semantickernel.semanticfunctions.annotations.DefineKernelFunction;
import com.microsoft.semantickernel.semanticfunctions.annotations.KernelFunctionParameter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SearchPlugin {

    private final EmbeddingService embeddingService;

    @SneakyThrows
    @DefineKernelFunction(name = "search",
            description = "Search for a information similar to the given query.")
    public String search(@KernelFunctionParameter(description = "Data on which to do action", name = "query") String query) {
        var points = embeddingService.search(query);
        log.info("Points: {}", points);
        return points.stream()
                .map(scoredPoint ->
                        scoredPoint.getPayloadMap().get("info").getStringValue()).findFirst().get();
    }
}
