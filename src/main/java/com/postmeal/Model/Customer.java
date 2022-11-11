package com.postmeal.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull
	@Size(min = 3,max = 30,message = "Name should be greater than 3 and less 30 words")
	private String firstName;
	
	private String lastName;
	
	@NotNull(message = "Age can not null")
	private Integer age;
	
	@NotNull(message = "gender can not null")
	private String gender;
	
	@NotNull
	@Pattern(regexp = "[0-9]{10}", message = "Mobile Number must contain 10 Digits")
	private String mobileNumber;
	
	@NotNull
	@Email(message =  "Email is not in 'example@email.com' format")
	private String email;
	@NotNull
	@Size(min = 6,max = 10,message = "password atlest contain six character and one special symbol")
	private String password;
	
	@Embedded
//	private Address address;
	@ElementCollection
	private Set<Address> address = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foodCart", referencedColumnName = "cartId")
	private FoodCart foodCart; 
}
