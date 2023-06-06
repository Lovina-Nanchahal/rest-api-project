package com.example.demo.dto;

import com.example.demo.model.*;
import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeSearchDTO {
    private List<SearchCriteria> searchCriteriaList;
}
