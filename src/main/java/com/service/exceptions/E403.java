package com.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FORBIDDEN)  
public class E403 extends RuntimeException{
	
	public E403(String message){
		this.message = message;
	}
	
	private String message;
	
	public String getMessage(){
		return message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
