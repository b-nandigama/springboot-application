package com.example.springbootapplication.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SpringbootAppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({BookNotFoundException.class})
	public ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({BookIdMismatchException.class,
					   DataIntegrityViolationException.class,
					   ConstraintViolationException.class
	})
	public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleInternalServerError(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(ex.getLocalizedMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
