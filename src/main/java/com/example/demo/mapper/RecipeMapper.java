package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class RecipeMapper {
    private final IngredientMapper ingredientMapper;
    private final InstructionMapper instructionMapper;

    public List<RecipeDTO> mapToRecipeDTOList(final List<Recipe> recipes) {
        return recipes.stream()
                .map(this::mapToRecipeDTO)
                .collect(Collectors.toList());
    }

    public RecipeDTO mapToRecipeDTO(final Recipe recipe) {
        List<IngredientDTO> ingredientDTOList = ingredientMapper.mapToIngredientDTOList(recipe.getIngredients());
        List<InstructionDTO> instructionDTOList = instructionMapper.mapToInstructionDTOList(recipe.getInstructions());

        return RecipeDTO.builder()
                .id(recipe.getId())
                .recipeName(recipe.getRecipeName())
                .recipeType(recipe.getRecipeType())
                .noOfServings(recipe.getNoOfServings())
                .ingredients(ingredientDTOList)
                .instructions(instructionDTOList)
                .build();
    }
}
