package com.example.demo.exception;

import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    public CustomExceptionHandler() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGlobalException(final Exception exception, final WebRequest webRequest) {
        log.error("Exception in recipe service: {}", exception.getMessage());
        return handleException(exception, HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    @ExceptionHandler(CustomValidationException.class)
    public final ResponseEntity<Object> handleCustomValidationException(final CustomValidationException exception, final WebRequest webRequest) {
        return handleException(exception, HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(final NotFoundException exception, final WebRequest webRequest) {
        return handleException(exception, HttpStatus.NOT_FOUND, webRequest);
    }

    private ResponseEntity<Object> handleException(final Exception exception, final HttpStatus httpStatus, final WebRequest webRequest) {
        return handleExceptionInternal(exception, "", headers, httpStatus, webRequest);
    }
}
