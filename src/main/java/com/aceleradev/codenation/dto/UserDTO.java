package com.aceleradev.codenation.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aceleradev.codenation.entity.Log;
import com.aceleradev.codenation.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class UserDTO {

	@NotEmpty
	@Size(min = 3, message = "Nome deve ter mais de 3 caracteres")
	private String fullName;
	@NotNull
	@Email(message = "Formato de email valido obrigatorio.")
	private String email;
	@NotNull
	@Size(min = 8, max = 50)
	private String password;
	private List<Log> log;

}
