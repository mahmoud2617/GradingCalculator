package com.mahmoud.gradesConversion.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ApiError> handleInvalidRequestException(Exception e) {
        return ResponseEntity.badRequest().body(
            ApiError.badRequest(e.getMessage())
        );
    }
}
