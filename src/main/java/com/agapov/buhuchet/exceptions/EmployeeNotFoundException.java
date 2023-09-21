package com.agapov.buhuchet.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "EmployeeNotFound")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
