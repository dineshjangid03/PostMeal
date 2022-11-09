package com.postmeal.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	private Integer addressId;
	
	private String buildingName;
	
	private String StreetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	
}
