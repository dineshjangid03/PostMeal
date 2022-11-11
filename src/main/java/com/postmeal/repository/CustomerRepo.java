package com.postMeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postMeal.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
}
