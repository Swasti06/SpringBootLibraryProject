package com.example.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import com.example.demo.exceptions.BookAPIException;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;

	public BookDTO addNewBookDetails(BookDTO bookDTO) {
		Book addBook = bookDTO.convertToEntity();
		Optional<Book> optionalBook = bookRepo.findById(addBook.getBookId());
		if (optionalBook.isPresent()) {
			throw new BookAPIException("Book Already exists");
		}
		Book savedBook = bookRepo.save(addBook);
		BookDTO savedBookDTO = savedBook.convertToDTO();
		return savedBookDTO;
	}

	public Book getBookDetailsWithId(int bookId) {

		Optional<Book> optionalBook = bookRepo.findById(bookId);
		Book bookDetails = optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		return bookDetails;
	}

//	public BookDTO getBookDetailsWithStudentDetails(int bookId) {
//
//		Optional<Book> optionalBook = bookRepo.findById(bookId);
//		Book bookDetails = optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
//		BookDTO convertToDTO = bookDetails.convertToDTO();
//		return convertToDTO;
//	}

	@Transactional
	public Book issueBookToStudent(int bookId, int studentId) {
		Optional<Book> optionalBook = bookRepo.findById(bookId);
		Book book = optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		if (book.getAvailability().equals("NO")) {
			throw new BookAPIException("Book is not available.");
		}
		book.setIssuedTo(studentId);
		book.setIssueDate(LocalDate.now());
		book.setAvailability("NO");
		return book;
	}

	@Transactional
	public String updateBookDetails(BookDTO bookDTOFromPayload) {
		Optional<Book> optionalBook = bookRepo.findById(bookDTOFromPayload.getBookId());
		optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		Book bookFromDB = optionalBook.get();
		if (bookDTOFromPayload.getBookName() != null) {
			bookFromDB.setBookName(bookDTOFromPayload.getBookName());
			;
		}
		if (bookDTOFromPayload.getAuthorName() != null) {
			bookFromDB.setAuthorName(bookDTOFromPayload.getAuthorName());
		}
		if (bookDTOFromPayload.getAvailability() != null) {
			bookFromDB.setAvailability(bookDTOFromPayload.getAvailability());
		}
		return "Book details updated";
	}

	public String deleteBookWithId(int id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		bookRepo.deleteById(id);
		return "Book is deleted";
	}

	@Transactional
	public Book returnBookFromStudent(int bookId, int studentId) {
		Optional<Book> optionalBook = bookRepo.findById(bookId);
		Book book = optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		if (book.getIssuedTo() != studentId) {
			throw new BookAPIException("Book is not issued to this student");
		}
		book.setIssuedTo(0);
		book.setAvailability("YES");
		book.setIssueDate(null);
		return book;
	}

	@Transactional
	public BookDTO issueBookToStudentWithResilience(int bookId, int studentId) {
		Optional<Book> optionalBook = bookRepo.findById(bookId);
		Book book = optionalBook.orElseThrow(() -> new BookAPIException("Book does not exist"));
		if (book.getAvailability().equals("NO")) {
			throw new BookAPIException("Book is not available.");
		}
		book.setIssuedTo(studentId);
		book.setAvailability("NO");
		BookDTO bookDTO=book.convertToDTO();
		return bookDTO;
	}

}
