package com.postmeal.Model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer billId;
	
	@NotNull(message = "Bill Date cannot ber null")
	private LocalDateTime billDate;
	
	@NotNull(message = "Order detail can not be null")
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;
	
	@NotNull(message = "Item Count can not be null")
	private Integer totalItem;
	
	@NotNull(message = "Cost can not be null")
	private Double totalCost;
}
