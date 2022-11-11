package com.postmeal.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.exception.CustomerException;
import com.postmeal.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo cRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			
		}
		
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
