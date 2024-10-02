package com.projectform.ms.volunteers.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{
    public MethodArgumentNotValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
