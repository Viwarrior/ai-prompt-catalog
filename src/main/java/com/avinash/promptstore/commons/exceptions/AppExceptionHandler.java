package com.avinash.promptstore.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.avinash.promptstore.usermanagement.exceptions.UserExistsException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleUserExistsException(UserExistsException exception) {
        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(exception.getMessage()),
                exception.getStatus());
    }
}