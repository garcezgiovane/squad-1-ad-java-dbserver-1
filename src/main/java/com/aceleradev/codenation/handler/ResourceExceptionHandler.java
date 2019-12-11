package com.aceleradev.codenation.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aceleradev.codenation.entity.ErrorDetails;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;
import com.aceleradev.codenation.service.exceptions.UserNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(LogNotFoundException.class)

	public ResponseEntity<ErrorDetails> handleLogNotFoundException(LogNotFoundException e, HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Log não encontrado");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(UserNotFoundException.class)

	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException e, HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Usuário não encontrado");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
