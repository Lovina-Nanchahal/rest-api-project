package com.example.demo.exception;

public final class CustomValidationException extends RuntimeException {
    public static final String RECIPE_REQUIRED_FIELDS = "Required fields were not present";

    public CustomValidationException(final String message) {
        super(message);
    }
}
