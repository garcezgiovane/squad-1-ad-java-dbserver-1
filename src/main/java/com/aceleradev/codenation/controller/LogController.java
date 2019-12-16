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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.dto.NewLogDTO;
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

	@ApiOperation(value = "Returns a list of filtered logs")
	@ResponseBody
	@GetMapping(produces="application/json")
	public ResponseEntity<?> getLogs(LogDTO logDTO) {
		return ResponseEntity.ok(logService.findLogs(logDTO));
	}

	@ApiOperation(value = "Returns a list of logs")
	@GetMapping(value = "/")
	public List<Log> findAll() {

		return logService.findAll();
	}

	@ApiOperation(value = "Return a log filtered by id")
	@GetMapping(value = "/{id}", produces="application/json")
	public Optional<Log> findById(@PathVariable("id") Long id) {

		return logService.findById(id);
	}

	@ApiOperation(value = "Save a log")
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid NewLogDTO newLogDTO) {
		
		return logService.save(newLogDTO);
	}

	@ApiOperation(value = "Delete a log by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {

		return logService.delete(id);
	}

	@ApiOperation(value = "Update a log by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody LogDTO logDTO, @PathVariable("id") Long id) {

		return logService.update(logDTO, id);
	}

}
