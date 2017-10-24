package com.grow.agriculture.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionalHandler {

     @ExceptionHandler(NoHandlerFoundException.class)
     public String handle(Exception ex) {

        return "404Error";
    }
}
