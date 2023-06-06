package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class IngredientMapper {
    public List<IngredientDTO> mapToIngredientDTOList(List<Ingredient> ingredients) {

        return ingredients.stream()
                .map(this::mapToIngredientDTO)
                .collect(Collectors.toList());
    }
    private IngredientDTO mapToIngredientDTO(final Ingredient ingredient) {
        return IngredientDTO.builder()
                .id(ingredient.getId())
                .ingredientName(ingredient.getIngredientName())
                .build();
    }
}
