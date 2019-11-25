package com.aceleradev.codenation.service;

import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Log> findByEnvironment(Environment environment) {
        return logRepository.findByEnvironment(environment);
    }

    public List<Log> findByEnvironmentAndLevel(Environment environment, Level level) {
        return logRepository.findByEnvironmentAndLevel(environment, level);
    }

    public List<Log> findByEnvironmentAndDescription(Environment environment, String description) {
        return logRepository.findByEnvironmentAndDescription(environment, description);
    }

    public List<Log> findByEnvironmentAndOrigin(Environment environment, String origin) {
        return logRepository.findByEnvironmentAndOrigin(environment, origin);
    }
}
