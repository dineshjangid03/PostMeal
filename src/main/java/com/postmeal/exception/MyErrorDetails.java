package com.postmeal.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class MyErrorDetails {
	
	private LocalDateTime ldt;
	
	private String msg;
	
	private String desc;
	
}
