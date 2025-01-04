package com.epam.training.gen.ai.plugin;

import com.epam.training.gen.ai.model.CurrencyExchangeRate;
import com.microsoft.semantickernel.semanticfunctions.annotations.DefineKernelFunction;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple plugin that defines a kernel function for performing a basic action on data.
 * <p>
 * This plugin exposes a method to be invoked by the kernel, which logs and returns the input query.
 */
@Slf4j
public class CurrencyConversionPlugin {

    private final Map<Integer, CurrencyExchangeRate> currencyExchangeRates = new HashMap<>();

    public CurrencyConversionPlugin() {
        currencyExchangeRates.put(1, new CurrencyExchangeRate(1, "USD", "UAH", "41.45"));
        currencyExchangeRates.put(2, new CurrencyExchangeRate(2, "UAH", "EUR", "0.023"));
    }

    @DefineKernelFunction(name = "get_currency_exchange_rates",
            description = "Gets a list of currency exchange rates")
    public List<CurrencyExchangeRate> getCurrencyExchangeRates() {
        log.info("Getting list of currency exchanges {}", currencyExchangeRates.values());
        return new ArrayList<>(currencyExchangeRates.values());
    }
}

