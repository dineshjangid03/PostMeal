package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postmeal.model.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Customer findByEmail(String email);
}
