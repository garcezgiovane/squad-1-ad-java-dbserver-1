package com.aceleradev.codenation.controller;

import com.aceleradev.codenation.dto.LogDTO;
import com.aceleradev.codenation.dto.LogResponseDTO;
import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.service.LogService;

import java.net.URI;

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
    public ResponseEntity<?> getLogs( LogDTO logDTO) {
        return ResponseEntity.ok(logService.findLogs( logDTO ));
    }
    
    @PostMapping
    public ResponseEntity<LogResponseDTO> save(@RequestBody Log log) {
        Log novoLog = logService.save(log); 
        return new ResponseEntity<>(LogResponseDTO.convertToDTO(novoLog), HttpStatus.CREATED);
    }
    
}
