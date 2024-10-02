package com.projectform.ms.volunteers.exceptions;

public class HttpMessageNotReadableException extends RuntimeException{
    public HttpMessageNotReadableException(String message, Throwable cause) {
        super(message, cause);
    }
}
