package com.example.springbootapplication.exception;

public class BookIdMismatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public BookIdMismatchException() {
		super();
	}
	
	public BookIdMismatchException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
