package com.aceleradev.codenation.service;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.repository.LogRepository;
import com.aceleradev.codenation.service.exceptions.LogNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

	public Log save(Log log) {
		log.setId(null);
		return logRepository.save(log);
	}
	
	public void delete(Long id) throws LogNotFoundException {
		try {
			logRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new LogNotFoundException("O Log não pode ser encontrado.");
		}
	}


}
