package com.agapov.buhuchet.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "EmployeeAlreadyAdded")
public final class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
