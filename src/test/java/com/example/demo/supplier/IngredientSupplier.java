package com.example.demo.supplier;

import com.example.demo.model.*;

public class IngredientSupplier {

    public static Ingredient getIngredient() {
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(2L);
        ingredient.setIngredientName("TestIngredient");

        ingredient.setRecipe(new Recipe());
        return ingredient;
    }
}
