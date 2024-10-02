package com.projectform.ms.volunteers.configs;


import com.projectform.ms.volunteers.exceptions.*;
import com.projectform.ms.volunteers.exceptions.NullPointerException;
import com.projectform.ms.volunteers.utils.ErrorResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.IllegalArgumentException;

@RestControllerAdvice
public class RestExceptionHandlerConfig {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<BodyException> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<BodyException> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<BodyException> handleIllegalArgumentException(IllegalArgumentException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<BodyException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    private ResponseEntity<BodyException> handleNoSuchElementException(NoSuchElementException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    private ResponseEntity<BodyException> handleNullPointerException(NullPointerException exception) {
        BodyException response = ErrorResponseUtil.buildErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
