package com.aceleradev.codenation.dto;

import java.time.LocalDateTime;

import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.User;
import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.entity.enums.LogStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LogDTO {

	private String title;
	private String description;
	private LocalDateTime eventDate;
	private Level level;
	private Environment environment;
	private String origin;
	private LogStatus logStatus;
	private Long frequency;
	private User user;
	private String order;
}
