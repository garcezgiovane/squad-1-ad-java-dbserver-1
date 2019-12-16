package com.aceleradev.codenation.service.exceptions;

public class UserAlreadyRegisteredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisteredException(String mensagem) {
		super(mensagem);
	}

}
