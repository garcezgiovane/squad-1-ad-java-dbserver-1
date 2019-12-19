package com.aceleradev.codenation.service.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String mensagem) {
		super(mensagem);
	}

}