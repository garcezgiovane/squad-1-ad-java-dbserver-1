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
public class ResponseLogDTO {
	
	private String title;
	private String description;
	private LocalDateTime eventDate;
	private Level level;
	private Environment environment;
	private String origin;
	private LogStatus logStatus;
	private Long frequency;
	private User user;

	public static ResponseLogDTO convertToDTO(Log log) {
	    return new ResponseLogDTO(log.getTitle(), log.getDescription(),
	    		log.getEventDate(), log.getLevel(), log.getEnvironment(), log.getOrigin(), log.getLogStatus(), log.getFrequency(), log.getUser());
	}
	
}
