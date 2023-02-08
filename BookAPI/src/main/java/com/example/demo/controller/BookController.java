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

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
@CrossOrigin
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/book/addBook")
	public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
		BookDTO newBook = bookService.addNewBookDetails(bookDTO);
		return new ResponseEntity<BookDTO>(newBook, HttpStatus.CREATED);
	}

	@GetMapping("/book/getBookDetails/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable int bookId) {
		Book receivedBook = bookService.getBookDetailsWithId(bookId);
		return new ResponseEntity<Book>(receivedBook, HttpStatus.CREATED);
	}

//	@GetMapping("/book/getBookDetailsWithStudentDetails/{bookId}")
//	public ResponseEntity<BookDTO> getBookDetailsWithStudentDetails(@PathVariable int bookId) {
//		BookDTO receivedBook=bookService.getBookDetailsWithStudentDetails(bookId);
//		return new ResponseEntity<BookDTO>(receivedBook, HttpStatus.CREATED) ;
//	}
	@PutMapping("/book/issueBookToStudent")
	public ResponseEntity<Book> issueBookToStudent(int bookId, int studentId) {
		Book addedBook = bookService.issueBookToStudent(bookId, studentId);
		return new ResponseEntity<Book>(addedBook, HttpStatus.CREATED);
	}

	@PutMapping("/book/issueBookToStudentWithResilience")
	public ResponseEntity<BookDTO> issueBookToStudentWithResilience(int bookId, int studentId) {
		if (bookId == 11003) {
			throw new RuntimeException();
		}
		BookDTO addedBook = bookService.issueBookToStudentWithResilience(bookId, studentId);
		return new ResponseEntity<BookDTO>(addedBook, HttpStatus.CREATED);
	}

	@PutMapping("/book/returnBookFromStudent")
	public ResponseEntity<Book> returnBookFromStudent(int bookId, int studentId) {
		Book returnedBook = bookService.returnBookFromStudent(bookId, studentId);
		return new ResponseEntity<Book>(returnedBook, HttpStatus.CREATED);
	}

	@PutMapping("/book/updateBook")
	public String updateBook(@RequestBody BookDTO bookDTO) {
		return bookService.updateBookDetails(bookDTO);
	}

	@DeleteMapping("/book/delBook/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBookWithId(id);
	}

}
