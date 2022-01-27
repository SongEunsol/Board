package com.nineone.board.controller.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nineone.board.dto.response.db.ResponseBuilder;

public class AbstractController {
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public ResponseEntity handleValidationExceptions(BindException ex) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            if (!sb.isEmpty()) {
                sb.append(System.getProperty("line.separator"));
            }
            sb.append(error.getDefaultMessage());
        });
        return ResponseBuilder.fail("1000", sb.toString());
    }
}
