package com.sarrussys.incaperapi.controllers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@CrossOrigin(origins = "*")
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> genericException(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(e.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(value = { NullPointerException.class })
    public ResponseEntity<Object> fieldIsNull(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(e.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(value = { NoSuchElementException.class })
    public ResponseEntity<Object> dataNotFound(Exception e) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMessage(e.getMessage());
        return buildResponseEntity(apiError);
    }
}
