package com.projectform.ms.volunteers.utils;

import com.projectform.ms.volunteers.exceptions.BodyException;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErrorResponseUtil {
    public static BodyException buildErrorResponse(String message, HttpStatus status) {
        BodyException response = new BodyException();
        response.setMessage(message);
        response.setError(status.getReasonPhrase());
        response.setStatus(String.valueOf(status.value()));
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return response;
    }
}
