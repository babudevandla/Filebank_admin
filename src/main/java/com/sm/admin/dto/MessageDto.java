package com.sm.admin.dto;

public class MessageDto {

	private String status;
	private String message;
	private Integer marks;
	private Integer total;
	private String email;
	private String password;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
