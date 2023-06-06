package com.example.demo.supplier;

import com.example.demo.model.*;

import java.util.*;

public class SearchCriteriaSupplier {
    public static List<SearchCriteria> getSearchCriteriaList() {
        final List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        searchCriteriaList.add(getSearchCriteriaRecipeType());
        searchCriteriaList.add(getSearchCriteriaServings());
        searchCriteriaList.add(getSearchCriteriaIncludesIngredients());
        searchCriteriaList.add(getSearchCriteriaExcludesIngredients());
        searchCriteriaList.add(getSearchCriteriaInstructions());
        return searchCriteriaList;
    }

    public static SearchCriteria getSearchCriteriaRecipeType() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setKey("recipeType");
        searchCriteria.setOperation("eq");
        searchCriteria.setValue("VEG");
        return searchCriteria;
    }

    public static SearchCriteria getSearchCriteriaServings() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setKey("noOfServings");
        searchCriteria.setOperation("eq");
        searchCriteria.setValue(4);
        return searchCriteria;
    }

    public static SearchCriteria getSearchCriteriaIncludesIngredients() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setKey("ingredients");
        searchCriteria.setOperation("in");
        searchCriteria.setValue("Potato");
        return searchCriteria;
    }

    public static SearchCriteria getSearchCriteriaExcludesIngredients() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setKey("ingredients");
        searchCriteria.setOperation("ex");
        searchCriteria.setValue("Salmon");
        return searchCriteria;
    }

    public static SearchCriteria getSearchCriteriaInstructions() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setKey("instructions");
        searchCriteria.setOperation("cn");
        searchCriteria.setValue("Oven");
        return searchCriteria;
    }
}
