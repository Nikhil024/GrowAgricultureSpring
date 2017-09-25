package com.grow.agriculture.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionalHandler {
	
		@ResponseStatus(value=HttpStatus.NOT_FOUND)
	     @ExceptionHandler(NoHandlerFoundException.class)
	     public String handle(Exception ex) {
	        return "404Error";
	}
	
}