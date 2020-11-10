package com.kaha.interview.assignment.library.dto;

public class ResponseDto {

	public String status;
	public String message;
	public DataResponse data;
	
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
	public DataResponse getData() {
		return data;
	}
	public void setData(DataResponse data) {
		this.data = data;
	}
	
	
	
	
}
