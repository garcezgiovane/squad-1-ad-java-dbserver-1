package com.aceleradev.codenation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
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

	@ApiOperation(value = "Returns a list of users")
	@GetMapping(produces="application/json")
	public List<User> findAll() {
		return userService.findAll();
	}

	@ApiOperation(value = "Return a user filtered by id")
	@GetMapping(value = "/{id}", produces="application/json")
	public Optional<User> findById(@PathVariable("id") Long id) {

		return userService.findById(id);
	}

	@ApiOperation(value = "Save a user")
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody UserDTO userDTO) {

		return userService.save(userDTO);
	}

	@ApiOperation(value = "Delete a user by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

		return userService.delete(id);
	}

	@ApiOperation(value = "Update a user by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO userDTO, @PathVariable("id") Long id) {

		return userService.update(userDTO, id);
	}

}
