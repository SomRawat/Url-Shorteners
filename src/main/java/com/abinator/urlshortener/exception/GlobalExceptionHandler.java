package com.abinator.urlshortener.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
import java.util.Map;

/**
 * Global exception handler for the application.
 * Provides centralized exception handling across all controllers.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * Handles validation constraint violations.
     * 
     * @param e the constraint violation exception
     * @return ResponseEntity with error details
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            final ConstraintViolationException e) {
        
        log.warn("Validation constraint violation: {}", e.getMessage());
        
        final Map<String, String> errorResponse = Map.of(
            "error", "Invalid input", 
            "message", e.getMessage()
        );
        
        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * Handles all other unexpected exceptions.
     * 
     * @param e the generic exception
     * @return ResponseEntity with generic error message
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(
            final Exception e) {
        
        log.error("Unexpected application error", e);
        
        final Map<String, String> errorResponse = Map.of(
            "error", "Internal server error"
        );
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorResponse);
    }
}