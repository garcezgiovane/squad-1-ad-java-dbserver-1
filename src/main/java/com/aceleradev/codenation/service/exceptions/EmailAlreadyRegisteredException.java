package com.aceleradev.codenation.service.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegisteredException(String mensagem) {
		super(mensagem);
	}

}
