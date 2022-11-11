package com.postmeal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//ENTITY Exception *****************
	
	@ExceptionHandler(ResturantNotFoundException.class)
	public ResponseEntity<MyErrorDetails> resturantNotFoundException(ResturantNotFoundException e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	// Handling the validation Exception eg. email password size etc;
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException mne){
		MyErrorDetails err = new MyErrorDetails();
		err.setLdt(LocalDateTime.now());
		err.setDesc(mne.getBindingResult().getFieldError().getDefaultMessage());
		err.setMsg(mne.getMessage());
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	// handling the null pointer exception**********************************
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<MyErrorDetails> nullPointerExceptionHandler(NullPointerException npe, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		err.setLdt(LocalDateTime.now());
		err.setMsg(npe.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	//All Type of Exception Handler 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundException(NoHandlerFoundException e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}
	
	
}
