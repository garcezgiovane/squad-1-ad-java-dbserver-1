package com.aceleradev.codenation.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.dto.NewLogDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.repository.LogRepository;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;

@Service
public class LogService {

	private LogRepository logRepository;

	@Autowired
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}

	public List<Log> findLogs(LogDTO logDTO) {
		if (Objects.nonNull(logDTO.getLevel())) {
			return logRepository.findByEnvironmentAndLevel(logDTO.getEnvironment(), logDTO.getLevel());
		}
		if (Objects.nonNull(logDTO.getOrigin())) {
			return logRepository.findByEnvironmentAndOrigin(logDTO.getEnvironment(), logDTO.getOrigin());
		}
		if (Objects.nonNull(logDTO.getDescription())) {
			return logRepository.findByEnvironmentAndDescription(logDTO.getEnvironment(), logDTO.getDescription());
		}
		if (Objects.nonNull(logDTO.getOrder())) {
			if (logDTO.getOrder().equals("frequency")) {
				return logRepository.findByEnvironmentOrderByFrequencyDesc(logDTO.getEnvironment());
			}
			return logRepository.findByEnvironmentOrderByLevelDesc(logDTO.getEnvironment());
		}
		return logRepository.findByEnvironment(logDTO.getEnvironment());
	}

	public List<Log> findAll(){
		return logRepository.findAll();
	}
	
	
	public Optional<Log> findById(Long id) {
		return logRepository.findById(id);
	}

	public ResponseEntity<Void> save(NewLogDTO newLogDTO) {

		Log log = new Log();		
		BeanUtils.copyProperties(newLogDTO, log);
		logRepository.save(log);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(log.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	public ResponseEntity<Void> delete(Long id) {
		try {
			logRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LogNotFoundException("O Log não pode ser encontrado.");
		}
		return ResponseEntity.noContent().build();
	}

	public ResponseEntity<Void> update(LogDTO logDTO, Long id) {
		try {
			Log log = new Log();
			BeanUtils.copyProperties(logDTO, log);
			log.setId(id);
			logRepository.findById(log.getId()).get();
			logRepository.save(log);
		} catch (NoSuchElementException e) {
			throw new LogNotFoundException("Log ausente. Não pode ser atualizado.");
		}
		return ResponseEntity.noContent().build();

	}

}
