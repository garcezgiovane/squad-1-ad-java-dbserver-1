package com.aceleradev.codenation.controller;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.service.LogService;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Log log) {
		Log novoLog = logService.save(log);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoLog.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws LogNotFoundException {
		logService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
