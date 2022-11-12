package com.postmeal.service;

import com.postmeal.Model.Customer;
import com.postmeal.exception.CustomerException;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Integer id) throws CustomerException;
	
	public Customer viewCustomer(Integer cID) throws CustomerException;
}
