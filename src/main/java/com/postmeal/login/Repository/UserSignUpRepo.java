package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.Model.Customer;
@Repository
public interface UserSignUpRepo extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmail(String email);
	
	public Customer findByCustomerId(Integer id);
}
