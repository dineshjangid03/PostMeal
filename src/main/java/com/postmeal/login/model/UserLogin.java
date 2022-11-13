package com.postmeal.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserLogin {
	@Id
	@Column(unique = true)
	private Integer userId;
	@Email(message = "email is not in proper format")
	private String userName;
	@NotNull
	private String password;

}
