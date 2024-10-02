package com.projectform.ms.volunteers.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
