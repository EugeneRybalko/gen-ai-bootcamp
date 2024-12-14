package com.epam.training.gen.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyExchangeRate {
    private Integer id;
    private String exchangeFrom;
    private String exchangeTo;
    private String exchangeRate;
}
