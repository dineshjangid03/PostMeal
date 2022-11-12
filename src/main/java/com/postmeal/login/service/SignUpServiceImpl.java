package com.postmeal.login.service;

import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.CustomerException;
import com.postmeal.exception.LogInException;
import com.postmeal.login.Repository.AdminSignUpRepo;
import com.postmeal.login.Repository.UserCurrentSessionRepo;
import com.postmeal.login.Repository.UserSignUpRepo;
import com.postmeal.login.model.AdminCurrentSession;
import com.postmeal.login.model.UserCurrentSession;
import com.postmeal.model.Customer;
import com.postmeal.model.Restaurant;
import com.postmeal.repository.CustomerRepo;
import com.postmeal.repository.RestaurantRepository;
@Service
public class SignUpServiceImpl implements SignUpService {
	@Autowired
	private UserSignUpRepo userRepo;
	@Autowired
	private AdminSignUpRepo adminRepo;
	@Autowired
	private CustomerRepo cRepo;
	@Autowired
	private UserCurrentSessionService usServ;
	@Autowired
	private AdminCurrentSessionService asServ;
	@Autowired
	private RestaurantRepository rRepo;
	
	@Override
	public Customer UserSignUp(Customer signUp) throws CustomerException {
		Customer customer = userRepo.findByEmail(signUp.getEmail());
		if(customer == null) {
			return userRepo.save(signUp);
		}
		throw new CustomerException("Email Already Exist");
	}
	@Override
	public Customer updateSignUpDetails(Customer signUp, String key) throws LogInException, CurrentUserSessException {
		UserCurrentSession signCustomer = usServ.getCurrentUserSession(key);
		if(signCustomer == null) {
			throw new LogInException("Not able update Login first...");
		}
		Optional<Customer> cust = cRepo.findById((signCustomer.getCustomerId()));
		if(cust.get().getEmail().equals(signUp.getEmail())) {
			return cRepo.save(signUp);
		}
		throw new LogInException("Please Check Email and passwrord");
		
	}
	@Override
	public Restaurant AdminSigUpDetails(Restaurant signUp) throws LogInException {
		Restaurant rest = adminRepo.findByRestaurantName(signUp.getRestaurantName());
		if(rest== null) {
			return adminRepo.save(signUp);
		}
		throw new LogInException("Restaurant Already presesent");
		
	}
	@Override
	public Restaurant updateAdminSignUpDetails(Restaurant rest, String key) throws LogInException {
		AdminCurrentSession Admin = asServ.getCurrentAdminSession(key);
		
		if(Admin==null) {
			throw new LogInException("Please Login first....");
		}
		
		Optional<Restaurant> rests = rRepo.findById(rest.getRestaurantId());
		if(rests.get().getRestaurantName().equals(rest.getRestaurantName())) {
			return rRepo.save(rest);
		}
		throw new LogInException("Please check Restaurant name");
		
	}

}
