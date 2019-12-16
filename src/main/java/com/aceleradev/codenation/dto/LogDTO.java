package com.aceleradev.codenation.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.aceleradev.codenation.entity.User;
import com.aceleradev.codenation.entity.enums.Environment;
import com.aceleradev.codenation.entity.enums.Level;
import com.aceleradev.codenation.entity.enums.LogStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LogDTO {

	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	@NotNull
	private LocalDateTime eventDate;
	@NotNull
	private Level level;
	@NotNull
	private Environment environment;
	@NotNull
	private String origin;
	@NotNull
	private LogStatus logStatus;
	@NotNull
	private Long frequency;
	@NotNull
	private User user;
}
