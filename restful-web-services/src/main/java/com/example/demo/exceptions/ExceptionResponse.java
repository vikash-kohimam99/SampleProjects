package com.example.demo.exceptions;

import java.util.Date;

public class ExceptionResponse {

	//Timestamp
	//message
	//details
	
	private Date timStamp;
	private String message;
	private String details;
	public ExceptionResponse(Date timStamp, String message, String details) {
		super();
		this.timStamp = timStamp;
		this.message = message;
		this.details = details;
	}
	
	
	public Date getTimStamp() {
		return timStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
	
	
}
