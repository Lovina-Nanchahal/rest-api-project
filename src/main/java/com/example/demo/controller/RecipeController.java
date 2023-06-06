package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.*;
import com.example.demo.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.*;

@RestController
@Slf4j
@AllArgsConstructor
@Validated
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping(value = "/addRecipe", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RecipeDTO saveRecipe(@RequestBody Recipe recipe){
        return recipeService.saveRecipe(recipe);
    }

    @GetMapping(value = "/getRecipe/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RecipeDTO getRecipeById(@PathVariable Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping(value = "/getAllRecipes", produces = APPLICATION_JSON_VALUE)
    public List<RecipeDTO> getRecipes() {
        return recipeService.getRecipes();
    }

    @GetMapping(value = "/searchRecipes", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<RecipeDTO> searchRecipes(@RequestBody RecipeSearchDTO recipeSearchDTO) {
        return recipeService.searchRecipes(recipeSearchDTO.getSearchCriteriaList());
    }

    @PutMapping(value = "/updateRecipe/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public RecipeDTO updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping(value = "/deleteRecipe/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return ResponseEntity.ok().build();
    }
}

