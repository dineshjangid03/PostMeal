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
@ToString

public class MyErrorDetails {
	
	private LocalDateTime timeStamp;
	
	private String message;
	
	private String Details;
	
}
