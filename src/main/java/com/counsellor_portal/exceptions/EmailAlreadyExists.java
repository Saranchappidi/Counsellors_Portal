package com.counsellor_portal.exceptions;

public class EmailAlreadyExists extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;
	String errorMessage;
	public EmailAlreadyExists(String errorMessage) {
		super();
		this.errorMessage=errorMessage;
	}

}
