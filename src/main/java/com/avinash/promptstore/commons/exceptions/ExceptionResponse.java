package com.avinash.promptstore.commons.exceptions;

import com.avinash.promptstore.commons.AppUtils;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private String timestamp;
    private String message;

    public ExceptionResponse(String message) {
        this.message = message;
        this.timestamp = AppUtils.getCurrentTime();
    }
}
