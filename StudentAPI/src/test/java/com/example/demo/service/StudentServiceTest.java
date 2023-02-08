package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Student;
import com.example.demo.exceptions.StudentAPIException;
import com.example.demo.repository.StudentRepository;

@SpringBootTest
public class StudentServiceTest {
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentRepository studentRepo;
	
	@Test
	void testIssueBookToStudentStudNotInDB() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		assertThrows(StudentAPIException.class, ()-> studentService.issueBookToStudent(11003, 123));
	}
	
	@Test 
	void testaddNewStudentWithStudentAlreadyAvailable() {
		Student newStudent= new Student();
		newStudent.setStudentId(1);
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(newStudent));
		assertThrows(StudentAPIException.class,()->studentService.addNewStudent(newStudent));
	}
	
	@Test
	void testIssueBookToStudentWithStudentIDBookIDZero() {
		assertThrows(StudentAPIException.class, ()->studentService.issueBookToStudent(0, 0));
	}
	
	@Test
	void testdeleteStudentWithIdWhenStudNotInDB() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		assertThrows(StudentAPIException.class, ()-> studentService.deleteStudentWithId(ArgumentMatchers.anyInt()));
	}
	
	@Test
	void testupdateStudentWhenStudNotInDB() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		Student newStudent= new Student();
		newStudent.setStudentId(1);
		assertThrows(StudentAPIException.class, ()-> studentService.updateExistingStudent(newStudent));		
	}
	
	@Test 
	void testaddNewStudentSuccessUsingNotNull() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		when(studentRepo.save(ArgumentMatchers.any())).thenReturn(new Student());
		Student addNewStudent=studentService.addNewStudent(new Student());
		assertNotNull(addNewStudent);
	}
	
	@Test 
	void testaddStudentSuccessUsingEquals() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		Student student= new Student();
		student.setStudentId(0);
		when(studentRepo.save(ArgumentMatchers.any())).thenReturn(new Student());
		Student addStudent=studentService.addNewStudent(new Student());
		assertNotNull(addStudent);
	}
}
