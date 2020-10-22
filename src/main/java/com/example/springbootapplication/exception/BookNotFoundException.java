package com.example.springbootapplication.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
