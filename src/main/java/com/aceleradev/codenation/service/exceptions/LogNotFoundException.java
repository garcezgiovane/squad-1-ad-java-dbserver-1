package com.aceleradev.codenation.service.exceptions;

public class LogNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LogNotFoundException(String mensagem) {
		super(mensagem);
	}

}
