package com.nineone.board.dto.response.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractResponseEntity {
    AbstractResponseHeaderEntity head;
    Object body;

    public AbstractResponseEntity(String errorCd, String errorMessage) {
        this.head = new AbstractResponseHeaderEntity(errorCd, errorMessage);
        this.body = null;
    }

    public AbstractResponseEntity(Object data) {
        this.head = new AbstractResponseHeaderEntity();
        this.body = data;
    }
}