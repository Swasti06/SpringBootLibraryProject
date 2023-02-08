package com.example.demo.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.BookAPIException;


@Aspect
@Component
public class BookLoggingAspect {
	
	public static final Log LOGGER = LogFactory.getLog(BookLoggingAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.getBook(..))", throwing="exception")
	public void afterThrowingforGetBookDetails(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.addBook(..))", throwing="exception")
	public void afterThrowingforAddBook(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.issueBookToStudent(..))", throwing="exception")
	public void afterThrowingforIssueBook(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.returnBookFromStudent(..))", throwing="exception")
	public void afterThrowingforReturnBook(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.updateBook(..))", throwing="exception")
	public void afterThrowingforUpdateBook(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.BookController.deleteBook(..))", throwing="exception")
	public void afterThrowingforDeleteBook(BookAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}

}
