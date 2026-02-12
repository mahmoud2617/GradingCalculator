package com.mahmoud.gradesConversion.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiError {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static ApiError badRequest(String message) {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), message);
    }
}
