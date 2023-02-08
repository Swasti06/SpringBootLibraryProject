package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.dto.BookDTO;

@Entity
public class Book {
	@Id
	private int bookId;
	private String bookName;
	private String authorName;
	private Integer issuedTo;
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
	
	public Integer getIssuedTo() {
		return issuedTo;
	}
	public void setIssuedTo(Integer issuedTo) {
		this.issuedTo = issuedTo;
	}
	public BookDTO convertToDTO() {
		BookDTO bookDTO= new BookDTO() ;
		bookDTO.setBookId(this.getBookId());
		bookDTO.setBookName(this.getBookName());
		bookDTO.setAuthorName(this.getAuthorName());
		//bookDTO.setIssueDate(this.getIssueDate());
		bookDTO.setAvailability(this.getAvailability());
		return bookDTO;		
	}
	
	
	
	
	

}
