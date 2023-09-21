package com.bruno.clutchskins.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFloatException extends RuntimeException {

    public InvalidFloatException(String message) {
        super(message);
    }

    public InvalidFloatException(String message, Throwable cause) {
        super(message, cause);
    }
}
