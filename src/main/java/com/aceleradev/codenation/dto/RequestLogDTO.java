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

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class RequestLogDTO {
	
	private String title;
	private String description;
	private LocalDateTime eventDate;
	private Level level;
	private Environment environment;
	private String origin;
	private LogStatus logStatus;
	private Long frequency;
	private User user;

	public Log convertToLog() {
	    return new Log(null, title, description,eventDate,level,environment,origin,logStatus,frequency,user);
		
	}
	
}
