package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.dto.StudentDTO;

@Entity
public class Student {
	@Id
	private int studentId;
	private String name;
	private String email;
	@Column(name="phoneNumber")
	private int phone;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public StudentDTO convertToDTO() {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(this.getStudentId());
		studentDTO.setName(this.getName());
		studentDTO.setEmail(this.getEmail());
		studentDTO.setPhone(this.getPhone());
		return studentDTO;
	}
	
	

}
