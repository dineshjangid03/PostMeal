package com.postmeal.login;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginDTO {
	
	private String userId;
	@Email(message = "email is not in proper format")
	private String userName;
	@NotNull
	private String password;

}
