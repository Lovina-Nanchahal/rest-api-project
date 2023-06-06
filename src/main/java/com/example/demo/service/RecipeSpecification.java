package com.example.demo.service;

import com.example.demo.model.*;
import jakarta.persistence.criteria.*;
import lombok.*;
import org.springframework.data.jpa.domain.*;

import java.util.*;

@RequiredArgsConstructor
public class RecipeSpecification implements Specification<Recipe> {

    private final SearchCriteria criteria;

    @Override
    public Predicate toPredicate
            (Root<Recipe> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        String searchString = criteria.getValue().toString();
        String filterKey = criteria.getKey();
        String searchOperation = criteria.getOperation();

        switch(Objects.requireNonNull(SearchOperation.getSimpleOperation(searchOperation))) {
            case EQUAL:
                if (filterKey.equalsIgnoreCase("recipeType") || filterKey.equalsIgnoreCase("noOfServings")) {
                    return builder.equal(root.<String>get(filterKey), searchString);
                }
            case INCLUDES:
                if (filterKey.equalsIgnoreCase("ingredients")) {
                    return builder.like(root.get(filterKey), "%" + searchString + "%");
                }
            case EXCLUDES:
                if (filterKey.equalsIgnoreCase("ingredients")) {
                    return builder.notLike(root.get(filterKey), "%" + searchString + "%");
                }
            case CONTAINS:
                if (filterKey.equalsIgnoreCase("instructions")) {
                    return builder.like(root.get(filterKey), "%" + searchString + "%");
                }
        }
        return null;
    }
}
