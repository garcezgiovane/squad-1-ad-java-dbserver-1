package com.aceleradev.codenation.service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceleradev.codenation.dto.UserDTO;
import com.aceleradev.codenation.entity.User;
import com.aceleradev.codenation.repository.UserRepository;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;
import com.aceleradev.codenation.service.exceptions.UserNotFoundException;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public ResponseEntity<Void> save(UserDTO userDTO) {

		User user = userDTO.convertToUser();
		userRepository.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	public ResponseEntity<Void> delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LogNotFoundException("O Usuário não pode ser encontrado.");
		}
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Void> update(UserDTO userDTO, Long id) {
		try {
			User user = userDTO.convertToUser();
			user.setId(id);
			userRepository.findById(user.getId()).get();
			userRepository.save(user);
		} catch (NoSuchElementException e) {
			throw new UserNotFoundException("Usuário ausente. Não pode ser atualizado.");
		}
		return ResponseEntity.noContent().build();

	}

}
