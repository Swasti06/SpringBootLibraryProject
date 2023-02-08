package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.entity.Book;

public class BookDTO {
	private int bookId;
	private String bookName;
	private String authorName;
	private LocalDate issueDate;
	private String availability;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Book convertToEntity() {
		Book book= new Book();
		book.setBookId(this.getBookId());;
		book.setBookName(this.getBookName());
		book.setAuthorName(this.getAuthorName());
		book.setIssueDate(this.getIssueDate());
		book.setAvailability(this.getAvailability());
		return book;
	}
}
