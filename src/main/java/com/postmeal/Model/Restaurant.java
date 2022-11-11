package com.postmeal.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString

public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	
	@NotNull
	@Size(min = 3,max = 256, message = "Restaurant Name should contain more than 3 and less than 256 words")
	private String restaurantName;
	
	@Embedded
	private Address address;
	
	@NotNull(message = "Manage Name can not null")
	private String managerName;
	
	@Pattern(regexp = "[0-9]{10}",message =  " contact Number should contain 10 Digits")
	private String contactNumber;
	@NotNull
	@Pattern(regexp = "[0-9]{1}[A-Z]{1}[a-z]",message =  "atleast contain NO. or special symbol ")
	@Size(min = 6,max = 10 ,message = "password ateleat should be six length")
	private String password;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Item> items;
	
}
