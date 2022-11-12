package com.postmeal.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.utility.nullability.MaybeNull;

@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter

public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	
	@Size(min = 3,max =256, message = "Item name sholud be greater than 3 and less than 256")
	private String ItemName;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CategoryId", referencedColumnName = "catId")
	private Category category;
	
	@NotNull(message = "quantity can not be null")
	private Integer quantity;
	
	@NotNull(message = "cost can not null")
	private Double cost;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Restaurant> restaurants;
	
}
