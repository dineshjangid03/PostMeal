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
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> itemExceptionHandler(ItemException e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderExceptionHandler(OrderException e,WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FoodCartException.class)
	public ResponseEntity<MyErrorDetails> foodCartExceptionHandler(FoodCartException e,WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResturantNotFoundException.class)
	public ResponseEntity<MyErrorDetails> resturantNotFoundException(ResturantNotFoundException e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<MyErrorDetails> categoryNotFoundException(CategoryNotFoundException e, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(e.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails> billExceptionHandler(BillException be, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(be.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		
		err.setLdt(LocalDateTime.now());
		err.setMsg(ce.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	//handling user current session Exception...
	
	@ExceptionHandler(CurrentUserSessException.class)
	public ResponseEntity<MyErrorDetails> userSessionHandler(CurrentUserSessException cse, WebRequest req){
		MyErrorDetails err = new MyErrorDetails();
		err.setLdt(LocalDateTime.now());
		
		err.setMsg(cse.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	// Handling Admin current Exception..
	
	@ExceptionHandler(CurrentAdminSessException.class)
	public ResponseEntity<MyErrorDetails> adminSessionHandler(CurrentAdminSessException csr, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setLdt(LocalDateTime.now());
		err.setMsg(csr.getMessage());
		err.setDesc(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	//Handling Login Exception
	
	@ExceptionHandler(LogInException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LogInException le, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setLdt(LocalDateTime.now());
		err.setMsg(le.getMessage());
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
	
	//All Type of Exception Handler.....
	
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
