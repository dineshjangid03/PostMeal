package com.postmeal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Customer;
import com.postmeal.exception.CustomerException;
import com.postmeal.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {

		
	@Autowired
	private CustomerService cImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerException {
		Customer cust = cImpl.addCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException {
		Customer cust = cImpl.updateCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) throws CustomerException {
		Customer cust = cImpl.removeCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
	}
	@GetMapping("/view")
	public ResponseEntity<Customer> viewCustomer(@RequestBody Customer customer) throws CustomerException {
		Customer cust = cImpl.viewCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
}
