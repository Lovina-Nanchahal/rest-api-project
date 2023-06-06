package com.example.demo.dto;

import lombok.*;

@Data
@Builder
public class IngredientDTO {
    @NonNull
    private Long id;

    @NonNull
    private String ingredientName;
}
