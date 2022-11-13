package com.postmeal.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
	
	
	private String password;
	
	@Embedded
	private Address address;
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "foodCart", referencedColumnName = "cartId")
//	private FoodCart foodCart; 
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="orderDetail", referencedColumnName = "orderId")
//	private List<OrderDetails> orders;
}
