package com.rtarcisio.olympic.services.exceptions;

public class MailSendException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	public MailSendException(String msg) {
		super(msg);
	}
}
