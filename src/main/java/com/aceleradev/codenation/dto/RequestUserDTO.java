package com.aceleradev.codenation.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class RequestUserDTO {

	private String fullName;
	private String email;
	private String password;
	private List<Log> log;

	public User convertToUser() {
		return new User(null, fullName, email, password, log);

	}

}
