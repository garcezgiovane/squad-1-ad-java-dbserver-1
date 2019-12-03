package com.aceleradev.codenation.entity;

import lombok.Data;

import javax.persistence.*;

import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;

import java.time.LocalDateTime;

@Entity
@Data
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime eventDate;
    private Level level;
    private Environment environment;
    private String origin;
    private Long frequency;

}
