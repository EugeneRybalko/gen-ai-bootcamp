package com.epam.training.gen.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private Integer id;
    private String name;
    private String description;
    private Boolean rented;
}
