package com.example.demo.service;

import com.example.demo.model.*;
import lombok.*;
import org.springframework.data.jpa.domain.*;

import java.util.*;

@RequiredArgsConstructor
public class RecipeSpecificationBuilder {
    private final List<SearchCriteria> params;

    public RecipeSpecificationBuilder(){
        this.params = new ArrayList<>();
    }

    public final RecipeSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public final RecipeSpecificationBuilder with(SearchCriteria searchCriteria) {
        params.add(searchCriteria);
        return this;
    }

    public Specification<Recipe> build() {
        if(params.size() == 0) {
            return null;
        }

        Specification<Recipe> result = new RecipeSpecification(params.get(0));

        for (int index = 1; index < params.size(); index++) {
            SearchCriteria criteria = params.get(index);

            result = Specification.where(result).and(new RecipeSpecification(criteria));
        }
        return result;
    }
}
