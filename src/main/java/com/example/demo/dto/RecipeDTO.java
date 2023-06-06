package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.*;
import java.util.*;

@Data
@Builder
public class RecipeDTO {
    @NonNull
    private Long id;

    @NonNull
    private String recipeName;

    @NonNull
    private String recipeType;

    @NonNull
    private Integer noOfServings;

    @NonNull
    private List<IngredientDTO> ingredients;

    @NonNull
    private List<InstructionDTO> instructions;
}
