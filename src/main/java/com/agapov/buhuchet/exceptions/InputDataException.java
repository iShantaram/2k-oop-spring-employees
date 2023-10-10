package com.agapov.buhuchet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputDataException extends RuntimeException {
    public InputDataException(String message) {
        super(message);
    }
}
