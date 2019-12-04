package com.aceleradev.codenation.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.entity.enums.LogStatus;

import lombok.Data;

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
	private LogStatus logStatus;
	private Long frequency;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

}
