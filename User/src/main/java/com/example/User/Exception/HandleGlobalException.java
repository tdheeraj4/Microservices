package com.example.User.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler
    public ResponseEntity<Error> handleResourceNotFoundException(MemberNotFoundException memberNotFoundException){
        Error error=new Error();
        error.setErrorCode("404");
        error.setMessage(memberNotFoundException.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Error> handleMemberNotFoundException(LongValueException memberNotFoundException){
        Error error=new Error();
        error.setErrorCode("500");
        error.setMessage(memberNotFoundException.getMessage());
        return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    }
}
