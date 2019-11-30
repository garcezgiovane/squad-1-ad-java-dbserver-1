package com.aceleradev.codenation.controller;

import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/logs")
public class LogController {

    private LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(value = "/{environment}")
    public ResponseEntity<?> getLogsByEnvironment(
            @PathVariable(value = "environment") Environment environment,
            @RequestParam(value = "order", required = false) String order) {
        if( order.equals("level") ) {
            return ResponseEntity.ok(logService.findByEnvironmentOrderByLevel(environment));
        }
        if( order.equals("frequency") ) {
            return ResponseEntity.ok(logService.findByEnvironmentOrderByFrequency(environment));
        }
        return ResponseEntity.ok(logService.findByEnvironment(environment));
    }

    @GetMapping(value = "/{environment}", params = "level")
    public ResponseEntity<?> getLogsByEnvironmentAndLevel(
            @PathVariable(value = "environment") Environment environment,
            @RequestParam(value = "level") Level level) {
        return ResponseEntity.ok(logService.findByEnvironmentAndLevel(environment, level));
    }

    @GetMapping(value = "/{environment}", params = "description")
    public ResponseEntity<?> getLogsByEnvironmentAndDescription(
            @PathVariable(value = "environment") Environment environment,
            @RequestParam(value = "description") String description) {
        return ResponseEntity.ok(logService.findByEnvironmentAndDescription(environment, description));
    }

    @GetMapping(value = "/{environment}", params = "origin")
    public ResponseEntity<?> getLogsByEnvironmentAndOrigin(
            @PathVariable(value = "environment") Environment environment,
            @RequestParam(value = "origin") String origin) {
        return ResponseEntity.ok(logService.findByEnvironmentAndOrigin(environment, origin));
    }
}
