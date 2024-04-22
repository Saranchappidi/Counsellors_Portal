package com.counsellor_portal.exceptions;

public class CounsellorNotFoundException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	String errorMessage;
	
	public CounsellorNotFoundException(String errorMessage) {
		super();
		this.errorMessage=errorMessage;
	}

}
