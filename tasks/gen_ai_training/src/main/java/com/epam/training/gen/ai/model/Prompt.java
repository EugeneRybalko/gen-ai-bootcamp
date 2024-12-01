package com.epam.training.gen.ai.model;

import lombok.Data;

@Data
public class Prompt {

    private String input;
    private Double temperature;
    private String modelName;
    private boolean functionsEnabled;
}
