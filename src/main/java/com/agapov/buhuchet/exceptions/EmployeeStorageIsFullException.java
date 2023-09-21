package com.agapov.buhuchet.exceptions;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "EmployeeStorageIsFull")
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
