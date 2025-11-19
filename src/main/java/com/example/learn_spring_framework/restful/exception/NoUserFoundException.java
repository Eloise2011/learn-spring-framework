package com.example.learn_spring_framework.restful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-18 20:01
 */

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class NoUserFoundException extends RuntimeException {
    public NoUserFoundException(String message) {
        super(message);
    }
}
