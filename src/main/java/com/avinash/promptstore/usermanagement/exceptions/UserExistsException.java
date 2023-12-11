package com.avinash.promptstore.usermanagement.exceptions;

import org.springframework.http.HttpStatusCode;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserExistsException extends RuntimeException {

    private String message;

    private HttpStatusCode status;

    public UserExistsException() {}

    public UserExistsException(HttpStatusCode status, String message)
    {
        super(message);
        this.message = message;
        this. status = status;
    }
}