package com.aceleradev.codenation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByEnvironment(Environment environment);
    List<Log> findByEnvironmentAndDescription(Environment environment, String description);
    List<Log> findByEnvironmentAndOrigin(Environment environment, String origin);
    List<Log> findByEnvironmentAndLevel(Environment environment, Level level);
    List<Log> findByEnvironmentOrderByLevelDesc(Environment environment);
    List<Log> findByEnvironmentOrderByFrequencyDesc(Environment environment);
	
}
