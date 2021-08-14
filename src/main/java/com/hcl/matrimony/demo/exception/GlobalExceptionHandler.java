package com.hcl.matrimony.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RecordAlreadyExistException.class)
	public ResponseEntity<String> HandleException(RecordAlreadyExistException exception) {
		return new ResponseEntity(exception.getMessage(), HttpStatus.ALREADY_REPORTED);
	}

}
