package com.postmeal.login.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.exception.SignupException;
import com.postmeal.login.LoginDTO;
import com.postmeal.loginRepo.CustomerDao;

    @Service
    public class LoginServiceImpl implements LoginService {
    @Autowired
	private CustomerDao cDao;
	@Override
	public String loginUser(LoginDTO dto) throws LoginException {
		Customer customer = cDao.findByEmail(dto.getUserName());
		
		if(customer !=null && customer.getPassword().equals(dto.getPassword()) && customer.getEmail().equals(dto.getUserName()) )
		{
			return "Login Successfull..!!";
		}
		else
			throw new LoginException("Invalid creditianal..!");
		
		
		
		
	}
	@Override
	public String signupUser(Customer custo) throws SignupException {
		Customer customer = cDao.findByEmail(custo.getEmail());
		
		if(customer ==null)
		{
			cDao.save(custo);
			return "Registered Sucessfull..";
		}
		else
			throw new SignupException("user already Existing With this Email..!!");
			
		
		
		
		
	}

}
