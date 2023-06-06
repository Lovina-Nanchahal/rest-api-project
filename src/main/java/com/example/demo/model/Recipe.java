package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "RECIPE")
@Data
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String recipeName;

    @Column(nullable = false)
    private String recipeType;

    @Column(nullable = false)
    private Integer noOfServings;

    @Column(nullable = false)
    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredients;

    @Column(nullable = false)
    @OneToMany(mappedBy = "recipe")
    private List<Instruction> instructions;
}
