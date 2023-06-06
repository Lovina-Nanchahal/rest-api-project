package com.example.demo.exception;

public final class NotFoundException extends RuntimeException {

    public static final String RECIPE_NOT_FOUND = "Recipe not found";

    public NotFoundException(final String message) {
        super(message);
    }
}
