package com.nineone.board.dto.response.db;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder extends ResponseEntity {

    public ResponseBuilder(HttpStatus status) {
        super(status);
        // TODO Auto-generated constructor stub
    }

    public static <T> ResponseEntity<AbstractResponseEntity> success(Object body) {
        return ok().body(new AbstractResponseEntity(body));
    }

    public static <T> ResponseEntity<AbstractResponseEntity> fail(String errorCd, String errorMessage) {
        return ok().body(new AbstractResponseEntity(errorCd, errorMessage));
    }
}