package com.rtarcisio.usuarios.service.exceptions;

public class DadosProtegidosException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DadosProtegidosException(String msg) {
		super(msg);
	}

}
