package com.aceleradev.codenation.service;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aceleradev.codenation.dto.FindLogDTO;
import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.User;
import com.aceleradev.codenation.repository.LogRepository;
import com.aceleradev.codenation.repository.UserRepository;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;
import com.aceleradev.codenation.service.exceptions.UserAlreadyRegisteredException;
import com.aceleradev.codenation.service.exceptions.UserNotFoundException;

@Service
public class LogService {

	private LogRepository logRepository;
	@Autowired
	public LogService(LogRepository logRepository, UserRepository userRepository) {
		this.logRepository = logRepository;
	}

	public List<Log> findLogs(FindLogDTO findLogDTO) {
		if (Objects.nonNull(findLogDTO.getLevel())) {
			return logRepository.findByEnvironmentAndLevel(findLogDTO.getEnvironment(), findLogDTO.getLevel());
		}
		if (Objects.nonNull(findLogDTO.getOrigin())) {
			return logRepository.findByEnvironmentAndOrigin(findLogDTO.getEnvironment(), findLogDTO.getOrigin());
		}
		if (Objects.nonNull(findLogDTO.getDescription())) {
			return logRepository.findByEnvironmentAndDescription(findLogDTO.getEnvironment(),
					findLogDTO.getDescription());
		}
		if (Objects.nonNull(findLogDTO.getOrder())) {
			if (findLogDTO.getOrder().equals("frequency")) {
				return logRepository.findByEnvironmentOrderByFrequencyDesc(findLogDTO.getEnvironment());
			}
			return logRepository.findByEnvironmentOrderByLevelDesc(findLogDTO.getEnvironment());
		}
		return logRepository.findByEnvironment(findLogDTO.getEnvironment());
	}

	public List<Log> findAll() {
		return logRepository.findAll();
	}

	public Optional<Log> findById(Long id) {
		return logRepository.findById(id);
	}

	public ResponseEntity<Void> save(LogDTO logDTO) {

		Log log = new Log();
		BeanUtils.copyProperties(logDTO, log);
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
