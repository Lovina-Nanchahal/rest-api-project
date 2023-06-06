package com.example.demo.service;

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
public class IngredientServiceTest {
    @InjectMocks
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @Test
    public void testSaveIngredients() {
        final Ingredient ingredient = IngredientSupplier.getIngredient();

        when(ingredientRepository.save(ingredient)).thenReturn(ingredient);

        ingredientService.saveIngredients(Collections.singletonList(ingredient), new Recipe());
    }

    @Test
    public void testDeleteIngredients() {
        final Ingredient ingredient = IngredientSupplier.getIngredient();

        doNothing().when(ingredientRepository).deleteAll(Collections.singletonList(ingredient));

        ingredientService.deleteIngredients(Collections.singletonList(ingredient));
    }
}
