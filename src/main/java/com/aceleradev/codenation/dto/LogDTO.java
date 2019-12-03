package com.aceleradev.codenation.dto;

import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import lombok.Data;

@Data
public class LogDTO {
    private Environment environment;
    private Level level;
    private String frequency;
    private String description;
    private String origin;
    private String order;
}
