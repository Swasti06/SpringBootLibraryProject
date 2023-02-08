package com.example.demo.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.exceptions.StudentAPIException;

@Aspect
@Component
public class StudentLoggingAspect {
	public static final Log LOGGER = LogFactory.getLog(StudentLoggingAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.getStudDetails(..))", throwing="exception")
	public void afterThrowingforGetStudDetails(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.addStudent(..))", throwing="exception")
	public void afterThrowingforAddStudent(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.issueBook(..))", throwing="exception")
	public void afterThrowingforIssueBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.returnBook(..))", throwing="exception")
	public void afterThrowingforReturnBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.updateStudent(..))", throwing="exception")
	public void afterThrowingforUpdateBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.example.demo.controller.StudentController.deleteStudent(..))", throwing="exception")
	public void afterThrowingforDeleteBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}

}
