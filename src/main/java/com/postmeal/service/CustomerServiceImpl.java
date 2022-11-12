package com.postmeal.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.exception.CustomerException;
import com.postmeal.model.Customer;
import com.postmeal.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepo cRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			throw new CustomerException("Customer Already Exist ....");
		}
		
		return cRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return cRepo.save(customer);
		}
		throw new CustomerException("No Customer Exist with this Data");
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			cRepo.delete(customer);
			return opt.get();
		}
		throw new CustomerException("No Customer Exist");
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cRepo.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CustomerException("No Customer Exist");
	}
	
	
	
}
