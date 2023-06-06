package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.supplier.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import java.util.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest {

    @InjectMocks
    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private IngredientService ingredientService;
    @Mock
    private InstructionService instructionService;
    @Mock
    private RecipeMapper recipeMapper;

    @Test
    public void testSaveRecipe() {
        final Recipe recipe = RecipeSupplier.getRecipe();
        when(recipeRepository.save(recipe)).thenReturn(recipe);

        doNothing().when(ingredientService).saveIngredients(recipe.getIngredients(), recipe);
        doNothing().when(instructionService).saveInstructions(recipe.getInstructions(), recipe);

        when(recipeMapper.mapToRecipeDTO(recipe)).thenReturn(RecipeDTOSupplier.getRecipeDto());

        RecipeDTO savedRecipe = recipeService.saveRecipe(recipe);
        Assertions.assertEquals(1, savedRecipe.getId());
    }

    @Test
    public void testUpdateRecipe() {
        final Recipe recipe = RecipeSupplier.getRecipe();

        Recipe updateRecipe = new Recipe();

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(updateRecipe));

        updateRecipe.setId(1L);
        updateRecipe.setRecipeName("Test");
        updateRecipe.setRecipeType("Non Veg");
        updateRecipe.setNoOfServings(3);

        when(recipeRepository.save(updateRecipe)).thenReturn(updateRecipe);

        doNothing().when(ingredientService).saveIngredients(recipe.getIngredients(), updateRecipe);
        doNothing().when(instructionService).saveInstructions(recipe.getInstructions(), updateRecipe);

        when(recipeRepository.saveAndFlush(updateRecipe)).thenReturn(updateRecipe);

        when(recipeMapper.mapToRecipeDTO(recipe)).thenReturn(RecipeDTOSupplier.getUpdatedRecipeDto());

        RecipeDTO updatedRecipe = recipeService.updateRecipe(1L, recipe);
        Assertions.assertEquals(1, updatedRecipe.getId());
        Assertions.assertEquals("Test", updatedRecipe.getRecipeName());
        Assertions.assertEquals("Non Veg", updatedRecipe.getRecipeType());
    }

    @Test
    public void testDeleteRecipe() {
        final Recipe recipe = RecipeSupplier.getRecipe();

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        doNothing().when(ingredientService).deleteIngredients(recipe.getIngredients());
        doNothing().when(instructionService).deleteInstructions(recipe.getInstructions());
        doNothing().when(recipeRepository).delete(recipe);

        recipeService.deleteRecipe(1L);
    }

    @Test
    public void getRecipeById() {
        final Recipe recipe = RecipeSupplier.getRecipe();

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        when(recipeMapper.mapToRecipeDTO(recipe)).thenReturn(RecipeDTOSupplier.getRecipeDto());

        RecipeDTO getRecipe = recipeService.getRecipeById(1L);
        Assertions.assertEquals("TestRecipe", getRecipe.getRecipeName());
    }

    @Test
    public void testGetRecipes() {
        final Recipe recipe = RecipeSupplier.getRecipe();
        when(recipeRepository.findAll()).thenReturn(Collections.singletonList(recipe));

        when(recipeMapper.mapToRecipeDTOList(Collections.singletonList(recipe))).thenReturn(Collections.singletonList(RecipeDTOSupplier.getRecipeDto()));

        final List<RecipeDTO> recipes = recipeService.getRecipes();
        Assertions.assertEquals(1, recipes.size());
    }

}
