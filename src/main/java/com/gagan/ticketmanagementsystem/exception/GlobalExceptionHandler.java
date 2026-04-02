package com.gagan.ticketmanagementsystem.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", ex.getStatusCode().value());
        body.put("error", ex.getStatusCode());
        // ex.getReason() pulls the "User with ID X not found" message you wrote
        body.put("message", ex.getReason());
        body.put("timestamp", java.time.LocalDateTime.now());

        return new ResponseEntity<>(body, ex.getStatusCode());
    }
}
