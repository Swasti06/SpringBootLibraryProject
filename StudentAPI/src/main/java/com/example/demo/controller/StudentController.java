package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student stud = studentService.addNewStudent(student);
		return new ResponseEntity<Student>(stud, HttpStatus.CREATED);
	}
	
	@GetMapping("/student/issueBook")
	public ResponseEntity<StudentDTO> issueBook(int bookId, int studentId) {
		StudentDTO studDTO=studentService.issueBookToStudent(bookId,studentId);
		return new ResponseEntity<StudentDTO>(studDTO,HttpStatus.OK);
	}

	@GetMapping("/student/returnBook")
	public ResponseEntity<StudentDTO> returnBook(int bookId, int studentId) {
		StudentDTO studDTO=studentService.returnBookFromStudent(bookId,studentId);
		return new ResponseEntity<StudentDTO>(studDTO,HttpStatus.OK);
	}
	
	@GetMapping("/student/getStudentDetails/{studentId}")
	public Student getStudDetails(@PathVariable int studentId) {
		return studentService.getStudentDetailsFromDB(studentId);
	}
	
	@GetMapping("/student/issueBookUsingResilience")
	public ResponseEntity<StudentDTO> issueBookUsingResilience(int studentId, int bookId) {
		StudentDTO issuedBook= studentService.issueBookUsingResilience(studentId, bookId);
		return new ResponseEntity<StudentDTO>(issuedBook,HttpStatus.CREATED);
	}

	@PutMapping("/student/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateExistingStudent(student);
	}
	@DeleteMapping("/student/delStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		return studentService.deleteStudentWithId(id);
	}
}
