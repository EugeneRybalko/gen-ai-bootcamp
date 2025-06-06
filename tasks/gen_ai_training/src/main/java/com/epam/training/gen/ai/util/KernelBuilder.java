package com.epam.training.gen.ai.util;

import com.azure.ai.openai.OpenAIAsyncClient;
import com.epam.training.gen.ai.plugin.CarRentalPlugin;
import com.epam.training.gen.ai.plugin.CurrencyConversionPlugin;
import com.epam.training.gen.ai.plugin.SearchPlugin;
import com.microsoft.semantickernel.Kernel;
import com.microsoft.semantickernel.aiservices.openai.chatcompletion.OpenAIChatCompletion;
import com.microsoft.semantickernel.plugin.KernelPlugin;
import com.microsoft.semantickernel.plugin.KernelPluginFactory;
import com.microsoft.semantickernel.services.chatcompletion.ChatCompletionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequiredArgsConstructor
public class KernelBuilder {

    public static final String CURRENCY_EXCHANGE_PLUGIN_NAME = "CurrencyConversionPlugin";
    public static final String CAR_RENTAL_PLUGIN_NAME = "CarRentalPlugin";
    public static final String SEARCH_PLUGIN_NAME = "SearchPlugin";

    private final OpenAIAsyncClient openAIAsyncClient;
    private final SearchPlugin searchPlugin;

    @Value("${client-azureopenai-deployment-name}")
    private String defaultModel;
    private Kernel kernel;

    public KernelBuilder withModel(String modelName) {
        kernel = createKernel(createChatCompletionService(modelName == null ? defaultModel : modelName));
        return this;
    }

    public Kernel build() {
        return kernel;
    }

    /**
     * Creates a {@link ChatCompletionService} bean for handling chat completions using Azure OpenAI.
     *
     * @param deploymentOrModelName the Azure OpenAI deployment or model name
     * @return an instance of {@link ChatCompletionService}
     */
    private ChatCompletionService createChatCompletionService(String deploymentOrModelName) {
        return OpenAIChatCompletion.builder()
                .withModelId(deploymentOrModelName)
                .withOpenAIAsyncClient(openAIAsyncClient)
                .build();
    }

    /**
     * Creates a {@link KernelPlugin} bean using a currency exchange plugin.
     *
     * @return an instance of {@link KernelPlugin}
     */
    private KernelPlugin createCurrencyExchangePlugin() {
        return KernelPluginFactory.createFromObject(
                new CurrencyConversionPlugin(), CURRENCY_EXCHANGE_PLUGIN_NAME);
    }

    /**
     * Creates a {@link KernelPlugin} bean using a car rental plugin.
     *
     * @return an instance of {@link KernelPlugin}
     */
    private KernelPlugin createCarRentalPlugin() {
        return KernelPluginFactory.createFromObject(
                new CarRentalPlugin(), CAR_RENTAL_PLUGIN_NAME);
    }

    /**
     * Creates a {@link KernelPlugin} bean using a search plugin.
     *
     * @return an instance of {@link KernelPlugin}
     */
    private KernelPlugin createSearchPlugin() {
        return KernelPluginFactory.createFromObject(searchPlugin, SEARCH_PLUGIN_NAME);
    }

    /**
     * Creates a {@link Kernel} bean to manage AI services and plugins.
     *
     * @param chatCompletionService the {@link ChatCompletionService} for handling completions
     * @return an instance of {@link Kernel}
     */
    private Kernel createKernel(ChatCompletionService chatCompletionService) {
        return Kernel.builder()
                .withAIService(ChatCompletionService.class, chatCompletionService)
                .withPlugin(createCurrencyExchangePlugin())
                .withPlugin(createCarRentalPlugin())
                .withPlugin(createSearchPlugin())
                .build();
    }

}
