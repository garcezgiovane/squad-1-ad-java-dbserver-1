package com.aceleradev.codenation.repository;

import com.aceleradev.codenation.entity.Environment;
import com.aceleradev.codenation.entity.Level;
import com.aceleradev.codenation.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {

    List<Log> findByEnvironment(Environment environment);
    List<Log> findByEnvironmentAndLevel(Environment environment, Level level);
    List<Log> findByEnvironmentAndDescription(Environment environment, String description);
    List<Log> findByEnvironmentAndOrigin(Environment environment, String origin);

    List<Log> findByEnvironmentOrderByLevelDesc(Environment environment);

    List<Log> findByEnvironmentOrderByFrequencyDesc(Environment environment);
}
