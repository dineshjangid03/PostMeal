package com.postmeal.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogin {
	@Id
	@Column(unique =true)
	private Integer adminId;
	@NotNull(message ="message userName Can Not be null")
	private String restaurantname;
	@NotNull(message = "Password Cannot Be not null")
	private String password;
	
}
