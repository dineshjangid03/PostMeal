package com.postmeal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode


public class Address {
	
	
	
	private String buildingName;
	
	private String StreetNo;
	
	private String area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	
	private String type;
	
	
}
