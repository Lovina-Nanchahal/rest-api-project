package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public void saveIngredients(final List<Ingredient> ingredients, final Recipe savedRecipe) {
        if(ingredients == null || ingredients.isEmpty()) {
            return;
        }
        for(Ingredient ingredient : ingredients) {
            ingredient.setRecipe(savedRecipe);

            ingredientRepository.save(ingredient);
        }
    }

    public void deleteIngredients(final List<Ingredient> ingredients) {
        if(ingredients == null || ingredients.isEmpty()) {
            return;
        }
        ingredientRepository.deleteAll(ingredients);
    }
}
