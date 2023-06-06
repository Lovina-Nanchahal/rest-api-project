package com.example.demo.supplier;

import com.example.demo.dto.*;

public class RecipeDTOSupplier {
    public static RecipeDTO getRecipeDto() {
        return RecipeDTO.builder()
                .id(1L)
                .recipeName("TestRecipe")
                .recipeType("Veg")
                .noOfServings(2)
                .ingredients(IngredientDTOSupplier.getIngredientDtoList())
                .instructions(InstructionDTOSupplier.getInstructionDtoList())
                .build();
    }

    public static RecipeDTO getUpdatedRecipeDto() {
        return RecipeDTO.builder()
                .id(1L)
                .recipeName("Test")
                .recipeType("Non Veg")
                .noOfServings(3)
                .ingredients(IngredientDTOSupplier.getIngredientDtoList())
                .instructions(InstructionDTOSupplier.getInstructionDtoList())
                .build();
    }
}
