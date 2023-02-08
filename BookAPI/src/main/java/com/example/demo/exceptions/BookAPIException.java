package com.example.demo.exceptions;

public class BookAPIException extends RuntimeException{
	public BookAPIException(String message) {
		super(message);
	}
}
