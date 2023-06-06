package com.example.demo.supplier;

import com.example.demo.dto.*;

import java.util.*;

public class IngredientDTOSupplier {

    public static IngredientDTO getIngredientDto() {
        return IngredientDTO.builder()
                .id(2L)
                .ingredientName("TestIngredient")
                .build();
    }

    public static List<IngredientDTO> getIngredientDtoList() {
        return Collections.singletonList(getIngredientDto());
    }
}
