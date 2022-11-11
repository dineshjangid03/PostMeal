package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postmeal.Model.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
}
