package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.exception.*;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.data.jpa.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;
    private final InstructionService instructionService;
    private final RecipeMapper recipeMapper;

    @Transactional
    public RecipeDTO saveRecipe(final Recipe recipe) {
        final Recipe savedRecipe = recipeRepository.save(recipe);

        ingredientService.saveIngredients(recipe.getIngredients(), savedRecipe);
        instructionService.saveInstructions(recipe.getInstructions(), savedRecipe);

        log.info("Saved recipe {}", savedRecipe);

        return recipeMapper.mapToRecipeDTO(savedRecipe);
    }

    @Transactional
    public RecipeDTO updateRecipe(Long id, Recipe recipe) {
        Recipe updateRecipe = findRecipeById(id);

        updateRecipe.setRecipeName(recipe.getRecipeName());
        updateRecipe.setRecipeType(recipe.getRecipeType());
        updateRecipe.setNoOfServings(recipe.getNoOfServings());

        recipeRepository.save(updateRecipe);

        List<Ingredient> ingredients = recipe.getIngredients();

        ingredientService.saveIngredients(ingredients, updateRecipe);
        updateRecipe.setIngredients(ingredients);

        List<Instruction> instructions = recipe.getInstructions();

        instructionService.saveInstructions(instructions, updateRecipe);
        updateRecipe.setInstructions(instructions);

        final Recipe updatedRecipe = recipeRepository.saveAndFlush(updateRecipe);
        log.info("Updated recipe {}", updatedRecipe);

        return recipeMapper.mapToRecipeDTO(updatedRecipe);
    }

    @Transactional
    public void deleteRecipe(Long id) {
        Recipe recipe = findRecipeById(id);

        ingredientService.deleteIngredients(recipe.getIngredients());
        instructionService.deleteInstructions(recipe.getInstructions());
        recipeRepository.delete(recipe);
    }

    @Transactional
    public RecipeDTO getRecipeById(Long id) {
        final Recipe recipe = findRecipeById(id);
        return recipeMapper.mapToRecipeDTO(recipe);
    }

    @Transactional
    public List<RecipeDTO> getRecipes() {
        final List<Recipe> recipes = recipeRepository.findAll();
        return recipeMapper.mapToRecipeDTOList(recipes);
    }

    @Transactional
    public List<RecipeDTO> searchRecipes(List<SearchCriteria> searchCriteriaList) {
        RecipeSpecificationBuilder recipeSpecificationBuilder = new RecipeSpecificationBuilder();

        if(searchCriteriaList != null) {
            searchCriteriaList.forEach(recipeSpecificationBuilder::with);
        }

        Specification<Recipe> recipeSpecification = recipeSpecificationBuilder.build();

        List<Recipe> recipes = recipeRepository.findAll(recipeSpecification);
        log.info("Searched recipes list size {}", recipes.size());

        return recipeMapper.mapToRecipeDTOList(recipes);
    }

    private Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NotFoundException.RECIPE_NOT_FOUND + id));
    }
}
