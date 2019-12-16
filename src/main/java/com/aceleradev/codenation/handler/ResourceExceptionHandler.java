package com.aceleradev.codenation.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aceleradev.codenation.entity.ErrorDetails;
import com.aceleradev.codenation.service.exceptions.EmailAlreadyRegisteredException;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;
import com.aceleradev.codenation.service.exceptions.UserAlreadyRegisteredException;
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

	public ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Usuário não encontrado");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(UserAlreadyRegisteredException.class)

	public ResponseEntity<ErrorDetails> handleUserAlreadyRegisteredException(UserAlreadyRegisteredException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Usuário já cadastrado");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(EmailAlreadyRegisteredException.class)

	public ResponseEntity<ErrorDetails> handleEmailAlreadyRegisteredException(EmailAlreadyRegisteredException e,
			HttpServletRequest request) {

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Email informado já cadastrado.");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
}
