package com.nineone.board.dto.response.db;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractResponseHeaderEntity {
    String errorCd;
    String errorMessage;
    String state;

    public AbstractResponseHeaderEntity(String errorCd, String errorMessage) {
        this.state = "2";
        this.errorCd = errorCd;
        this.errorMessage = errorMessage;
    }

    public AbstractResponseHeaderEntity() {
        this.state = "1";
        this.errorCd = null;
        this.errorMessage = null;
    }
}