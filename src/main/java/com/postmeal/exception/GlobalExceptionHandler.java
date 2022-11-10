package com.postmeal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//ENTITY Exception *****************
	
	
	
	
	
	
	
	
	
	
	
	
	// Handling the validation Exception eg. email password size etc;
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException mne){
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(mne.getMessage());
		err.setDetails(mne.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	// handling the null pointer exception**********************************
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<MyErrorDetails> nullPointerExceptionHandler(NullPointerException npe, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(npe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	//All Type of Exception Handler 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
