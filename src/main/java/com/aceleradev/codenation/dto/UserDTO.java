package com.aceleradev.codenation.dto;

import java.util.List;

import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class UserDTO {

	private String fullName;
	private String email;
	private String password;
	private List<Log> log;

	public User convertToUser() {
		return new User(null, fullName, email, password, log);

	}

}
