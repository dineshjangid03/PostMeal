package com.postmeal.login.service;


import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.CustomerException;
import com.postmeal.exception.LogInException;
import com.postmeal.model.Customer;
import com.postmeal.model.Restaurant;

public interface SignUpService {
	
	public Customer UserSignUp(Customer signUp) throws CustomerException;
	
	public Customer updateSignUpDetails(Customer sugnUp,String key) throws LogInException, CurrentUserSessException;
	
	public Restaurant AdminSigUpDetails(Restaurant signUp) throws LogInException;
	
	public Restaurant updateAdminSignUpDetails(Restaurant rest, String key) throws LogInException;

}
