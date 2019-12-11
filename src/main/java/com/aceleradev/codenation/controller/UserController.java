package com.aceleradev.codenation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aceleradev.codenation.dto.UserDTO;
import com.aceleradev.codenation.entity.User;
import com.aceleradev.codenation.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {

		return userService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody UserDTO userDTO) {

		return userService.save(userDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

		return userService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable("id") Long id) {

		return userService.update(userDTO, id);
	}

}
