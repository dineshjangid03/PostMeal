package com.postmeal.login.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class UserCurrentSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private Integer userId;
	
	@Column(unique = true)
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

}
