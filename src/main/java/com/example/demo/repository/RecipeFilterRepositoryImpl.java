package com.example.demo.repository;

import lombok.*;

//@Repository
@RequiredArgsConstructor
public class RecipeFilterRepositoryImpl {

    /*@Autowired
    private final MongoTemplate mongoTemplate;*/

    /*public List<Recipe> findRecipesByProperties(RecipeType recipeType, String includesIngredient, String excludesIngredient,
                                                int noOfServings, String instructionText, Pageable page) {
        final Query query = new Query().with(page);
        query.fields().include("id").include("recipeName").include("recipeType").include("ingredients").include("noOfServings").include("instructions");

        final List<Criteria> criteria = new ArrayList<>();

        if (recipeType.toString() != null && !recipeType.toString().isEmpty())
            criteria.add(Criteria.where("recipeType").is(recipeType));
        if (noOfServings != 0)
            criteria.add(Criteria.where("noOfServings").is(noOfServings));
        if (instructionText != null && !instructionText.isEmpty())
            criteria.add(Criteria.where("instructions").in(instructionText));
        if (includesIngredient != null && !includesIngredient.isEmpty())
            criteria.add(Criteria.where("ingredients").in(includesIngredient));
        if (excludesIngredient != null && !excludesIngredient.isEmpty())
            criteria.add(Criteria.where("ingredients").nin(excludesIngredient));

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        //return mongoTemplate.find(query, Recipe.class);
        return null;
    }*/
}
