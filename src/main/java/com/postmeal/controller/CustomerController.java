package com.postMeal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

		
	@Autowired
	private CustomerService cImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException {
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
