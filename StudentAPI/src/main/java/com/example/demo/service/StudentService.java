package com.example.demo.service;

import java.awt.print.Book;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.StudentAPIException;
import com.example.demo.repository.StudentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RefreshScope
@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${url}")
	String url;

	public Student addNewStudent(Student student) {
		Optional<Student> optionalStudent = studentRepo.findById(student.getStudentId());
		if(optionalStudent.isPresent()) {
			throw new StudentAPIException("Student already exists");
		}
		return studentRepo.save(student);
	}
	
	public Student getStudentDetailsFromDB(int studentId) {
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		Student studentDetails = optionalStudent
				.orElseThrow(() -> new StudentAPIException("Student does not exist"));
		return studentDetails;
	}
	

	public String updateExistingStudent(Student studentFromPayload) {
		Optional<Student> optionalStudent = studentRepo.findById(studentFromPayload.getStudentId());
		optionalStudent.orElseThrow(()-> new StudentAPIException("Student does not exist"));
		Student studentFromDB= optionalStudent.get();
		if(studentFromPayload.getName() != null) {
			studentFromDB.setName(studentFromPayload.getName());;
		}
		if(studentFromPayload.getEmail() != null) {
			studentFromDB.setEmail(studentFromPayload.getEmail());
		}
		if(studentFromPayload.getPhone() != 0) {
			studentFromDB.setPhone(studentFromPayload.getPhone());
		}
		return "Student details updated";
	}

	public String deleteStudentWithId(int id) {
		Optional<Student> optionalStudent = studentRepo.findById(id);
		optionalStudent.orElseThrow(()-> new StudentAPIException("Student does not exist"));
		studentRepo.deleteById(id);
		return "Student is deleted";
	}

	public StudentDTO issueBookToStudent(int bookId, int studentId) {
		if(bookId==0 || studentId==0) {
			throw new StudentAPIException("Either bookId or studentId is null");
		}
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		Student student = optionalStudent.orElseThrow(()-> new StudentAPIException("Student not available"));
		
		StudentDTO studentDTO=student.convertToDTO();
		ResponseEntity<BookDTO> exchange=restTemplate.exchange(url+"/book/issueBookToStudent?bookId={bookId}&studentId={studentId}",
				HttpMethod.PUT,null,BookDTO.class,bookId,studentId);
		BookDTO bookDTO=exchange.getBody();
		//bookDTO.setAvailability("NO");
		studentDTO.setBookDTO(bookDTO);
		return studentDTO;
	}

	public StudentDTO returnBookFromStudent(int bookId, int studentId) {
		if(bookId==0 && studentId==0) {
			throw new StudentAPIException("Either bookId or studentId is null");
		}
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		Student student = optionalStudent.orElseThrow(()-> new StudentAPIException("Student not available"));
		StudentDTO studentDTO=student.convertToDTO();
		ResponseEntity<BookDTO> exchange=restTemplate.exchange(url+"/book/returnBookFromStudent?bookId={bookId}&studentId={studentId}",
				HttpMethod.PUT,null,BookDTO.class,bookId,studentId);
		BookDTO bookDTO=exchange.getBody();
		//bookDTO.setAvailability("YES");
		studentDTO.setBookDTO(bookDTO);
		return studentDTO;	}

	@CircuitBreaker(name="studentService", fallbackMethod="getStudentfallbackmethod")
	public StudentDTO issueBookUsingResilience(int studentId, int bookId) {
		if(bookId==0 && studentId==0) {
			throw new StudentAPIException("Either bookId or studentId is null");
		} 
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		Student student=optionalStudent.orElseThrow(()-> new StudentAPIException("Student not availabe in DB"));
		BookDTO bookDTO = new BookDTO();
		bookDTO.setIssuedTo(studentId);
		ResponseEntity<BookDTO> exchange=restTemplate.exchange(url+"/book/issueBookToStudentWithResilience?bookId={bookId}&studentId={studentId}", HttpMethod.PUT,null,BookDTO.class,bookId,studentId);
		StudentDTO studentDTO=student.convertToDTO();
		studentDTO.setBookDTO(exchange.getBody());
				return studentDTO;
	}
	public StudentDTO getStudentfallbackmethod(int bookId, int studentId, Throwable throwable) {
		System.out.println("fallback");
		return  new StudentDTO();
	}
	
	
//	@CircuitBreaker(name="studentService", fallbackMethod="getStudentfallbackmethod")
//	public StudentDTO getStudentAndBookData(int studentId, int bookId) {
//		Optional<Student> optionalStudent = studentRepo.findById(studentId);
//		Student studentDetails = optionalStudent
//				.orElseThrow(() -> new StudentAPIException("Student does not exist"));
//		ResponseEntity<BookDTO> exchangeObject=restTemplate.exchange(url+"/book/getBookDetails/{bookId}", HttpMethod.PUT,null,BookDTO.class,bookId);
//		StudentDTO objectOfStudentDTO=studentDetails.convertToDTO();
//		objectOfStudentDTO.setBookDTO(exchangeObject);
//		return objectOfStudentDTO;
//	}
//	
//	public StudentDTO getStudentfallbackmethod(int id, Throwable throwable) {
//		System.out.println("fallback");
//		return  new StudentDTO();
//	}

	

	
	

	
}
