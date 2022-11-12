package com.postmeal.service;

import com.postmeal.exception.CustomerException;
import com.postmeal.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;
}
