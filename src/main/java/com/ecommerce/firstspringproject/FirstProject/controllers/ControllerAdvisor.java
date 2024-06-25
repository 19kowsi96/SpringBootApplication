package com.ecommerce.firstspringproject.FirstProject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//global exception handler @ControllerAdvice
@ControllerAdvice
public class ControllerAdvisor {
    //how to handle the exceptions
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleException(Exception ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullPointerException.class)
    public void handleNullException(Exception ex)
    {
        System.out.println(ex.getMessage());
    }

}
