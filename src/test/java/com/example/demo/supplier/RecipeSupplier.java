package com.example.demo.supplier;

import com.example.demo.model.*;

import java.util.*;

public class RecipeSupplier {
    public static Recipe getRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setRecipeName("TestRecipe");
        recipe.setRecipeType("Veg");
        recipe.setNoOfServings(2);
        recipe.setIngredients(Collections.singletonList(IngredientSupplier.getIngredient()));
        recipe.setInstructions(Collections.singletonList(InstructionSupplier.getInstruction()));
        return recipe;
    }
}
