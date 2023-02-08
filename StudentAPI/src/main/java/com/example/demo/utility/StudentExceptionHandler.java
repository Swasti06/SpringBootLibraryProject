package com.example.demo.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {
	
//	@ExceptionHandler
//	public ResponseEntity<String> handleAllExceptions(Exception exception){
//		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorInfo> handleAllExceptions(Exception exception){
		ErrorInfo error= new ErrorInfo();
		error.setErrorcode(HttpStatus.NOT_FOUND);
		error.setMessage(exception.getMessage());
		error.setTime(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
