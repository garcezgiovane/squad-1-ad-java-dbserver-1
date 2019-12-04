package com.aceleradev.codenation.controller;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.dto.RequestLogDTO;
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
	public ResponseEntity<Void> save(@RequestBody RequestLogDTO requestLogDTO) {
		
		Log log = logService.save(requestLogDTO.convertToLog());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		logService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody RequestLogDTO requestLogDTO, @PathVariable("id") Long id) {
		Log log = requestLogDTO.convertToLog();
		log.setId(id);
		logService.update(log);

		return ResponseEntity.noContent().build();
	}

}
