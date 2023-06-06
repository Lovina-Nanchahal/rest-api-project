package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.service.*;
import com.example.demo.supplier.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.http.*;
import java.util.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTest {

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private RecipeService recipeService;

    @Test
    public void testSaveRecipe() {
        final Recipe recipe = RecipeSupplier.getRecipe();

        final RecipeDTO recipeDTO = RecipeDTOSupplier.getRecipeDto();

        when(recipeService.saveRecipe(recipe)).thenReturn(recipeDTO);
        final RecipeDTO savedRecipe = recipeController.saveRecipe(recipe);
        Assertions.assertEquals(1, savedRecipe.getId());
        Assertions.assertEquals("TestRecipe", savedRecipe.getRecipeName());
    }

    @Test
    public void testGetRecipeById() {
        final RecipeDTO recipeDTO = RecipeDTOSupplier.getRecipeDto();
        when(recipeService.getRecipeById(anyLong())).thenReturn(recipeDTO);

        final RecipeDTO getRecipe = recipeController.getRecipeById(1L);
        Assertions.assertEquals(1, getRecipe.getId());
        Assertions.assertEquals("TestRecipe", getRecipe.getRecipeName());
    }

    @Test
    public void testGetRecipes() {
        final RecipeDTO recipeDTO = RecipeDTOSupplier.getRecipeDto();
        when(recipeService.getRecipes()).thenReturn(Collections.singletonList(recipeDTO));

        final List<RecipeDTO> recipes = recipeController.getRecipes();
        Assertions.assertEquals(1, recipes.size());
    }

    @Test
    public void testUpdateRecipe() {
        final Recipe recipe = RecipeSupplier.getRecipe();
        final RecipeDTO recipeDTO = RecipeDTOSupplier.getRecipeDto();

        when(recipeService.updateRecipe(1L, recipe)).thenReturn(recipeDTO);
        final RecipeDTO updatedRecipe = recipeController.updateRecipe(1L, recipe);
        Assertions.assertEquals(1, updatedRecipe.getId());
    }


    @Test
    public void testDeleteRecipe() {
        doNothing().when(recipeService).deleteRecipe(anyLong());
        Assertions.assertEquals(ResponseEntity.ok().build(), recipeController.deleteRecipe(1L));
    }
}

