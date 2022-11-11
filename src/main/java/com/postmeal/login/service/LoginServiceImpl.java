package com.postmeal.login.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.SignupException;
import com.postmeal.login.CurrentUserSession;
import com.postmeal.login.LoginDTO;
import com.postmeal.loginRepo.AdminCurrentSess;
import com.postmeal.loginRepo.CustomerDao;
import com.postmeal.loginRepo.UserCurreSession;

import net.bytebuddy.utility.RandomString;

    @Service
    public class LoginServiceImpl implements LoginService {
    @Autowired
	private CustomerDao cDao;
    @Autowired
    private AdminCurrentSess adminDao;
    @Autowired
    private UserCurreSession userSessDao;
	@Override
	public String loginUser(LoginDTO dto) throws LoginException, CurrentUserSessException {
		Customer customer = cDao.findByEmail(dto.getUserName());
		
		if(customer==null)
		{
			throw new LoginException("Invalid email...");
			
		}
		
		Optional<CurrentUserSession> cuserSess = userSessDao.findById(customer.getCustomerId()); 
		
		if(cuserSess !=null)
		{
			throw new CurrentUserSessException("User already LoggedIn");
		}
		
		if(customer !=null && customer.getPassword().equals(dto.getPassword()) && customer.getEmail().equals(dto.getUserName()) )
		{
			
			
			CurrentUserSession currUsess= new CurrentUserSession();
			
			currUsess.setLocalDateTime(LocalDateTime.now());
			currUsess.setUuid(RandomString.make(6));
			userSessDao.save(currUsess);
			
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
