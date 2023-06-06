package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.data.jpa.repository.*;

public interface RecipeRepository extends JpaRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {
}
