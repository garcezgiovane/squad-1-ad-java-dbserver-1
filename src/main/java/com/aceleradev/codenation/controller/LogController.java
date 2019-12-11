package com.aceleradev.codenation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.service.LogService;

@RestController
@RequestMapping("api/v1/logs")
public class LogController {

	private LogService logService;

	@Autowired
	public LogController(LogService logService) {
		this.logService = logService;
	}

	@ResponseBody
	@GetMapping
	public ResponseEntity<?> getLogs(LogDTO logDTO) {
		return ResponseEntity.ok(logService.findLogs(logDTO));
	}

	@GetMapping(value = "/{id}")
	public Optional<Log> finById(@PathVariable("id") Long id) {

		return logService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody LogDTO logDTO) {

		return logService.save(logDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

		return logService.delete(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody LogDTO logDTO, @PathVariable("id") Long id) {

		return logService.update(logDTO, id);
	}

}
