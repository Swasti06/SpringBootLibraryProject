package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BookDTO;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class BookServiceTest {
	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepository bookRepo;

//	@Test 
//	void testaddNewBookDetailsSuccessUsingNotNull() {
//		when(bookRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
//		when(bookRepo.save(ArgumentMatchers.any())).thenReturn(new BookDTO());
//		BookDTO addNewBook=bookService.addNewBookDetails(new BookDTO());
//		assertNotNull(addNewBook);
//	}
	
	
}
