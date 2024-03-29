package com.postmeal.login.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.CurrentAdminSessException;
import com.postmeal.exception.LogInException;
import com.postmeal.exception.SignupException;
import com.postmeal.login.Repository.AdminCurrentSessionRepo;
import com.postmeal.login.Repository.AdminLoginRepo;
import com.postmeal.login.Repository.AdminSignUpRepo;
import com.postmeal.login.Repository.UserCurrentSessionRepo;
import com.postmeal.login.Repository.UserLoginRepo;
import com.postmeal.login.model.AdminCurrentSession;
import com.postmeal.login.model.AdminLogin;
import com.postmeal.login.model.UserCurrentSession;
import com.postmeal.login.model.UserLogin;
import com.postmeal.repository.CustomerRepo;
import com.postmeal.repository.RestaurantRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private UserLoginRepo ulRepo;
	@Autowired
	private CustomerRepo cRepo;
	@Autowired
	private UserCurrentSessionRepo userRepo;
	@Autowired
	private RestaurantRepository rRepo;
	@Autowired
	private AdminCurrentSessionRepo acsRepo;
	@Autowired
	private AdminLoginRepo alRepo;


	@Override
	public String loginUser(UserLogin dto) throws LogInException {
		Customer customer = cRepo.findByEmail(dto.getUserMail());
		if(customer==null) {
			throw new LogInException("Invalid Email...");
		}
		
		UserCurrentSession currUserOpt = userRepo.findByCustomerId(customer.getCustomerId());
		if(currUserOpt != null) {
			throw new LogInException("User Already Logged In...");
		}
		if (customer != null && customer.getPassword().equals(dto.getPassword())&& customer.getEmail().equals(dto.getUserMail())) {
			UserCurrentSession ucs = new UserCurrentSession();
			ucs.setUserId(customer.getCustomerId());
			ucs.setLocalDateTime(LocalDateTime.now());
			ucs.setCustomerId(customer.getCustomerId());
			ucs.setUuid(RandomString.make(6));
			userRepo.save(ucs);
			UserLogin ulogin = new UserLogin(ucs.getCustomerId(), dto.getUserMail(),dto.getPassword());
			ulRepo.save(ulogin);
			return ucs.toString() +"   ..Logged Successfully  ";
		} else
			throw new LogInException("Invalid creditianal..!");

	}
	@Override
	public String userLogOut(String uuid) throws LogInException {
		UserCurrentSession ucs = userRepo.findByUuid(uuid);
		if(ucs==null) {
			throw new LogInException("Please Login first....");
		}
		
		Optional<UserLogin> ul = ulRepo.findById(ucs.getCustomerId());
		
		ulRepo.delete(ul.get());
		userRepo.delete(ucs);
		return "Logged Out...";
	}
	
	@Override
	public String adminLogin(AdminLogin adminData) throws LogInException, CurrentAdminSessException {
		Restaurant rest = rRepo.findByRestaurantName(adminData.getRestaurantname());
		if(rest == null ) {
			throw new LogInException("No Restaurant Registered with Name "+adminData.getRestaurantname());
		}
		AdminCurrentSession acs = acsRepo.findByRestaurantId(rest.getRestaurantId());
		if(acs!=null) {
			throw new CurrentAdminSessException("Admin Already Logged In ...");
		}
		if(rest.getRestaurantName().equals(adminData.getRestaurantname()) && rest.getPassword().equals(adminData.getPassword())) {
			AdminCurrentSession acsess = new AdminCurrentSession();
			acsess.setId(rest.getRestaurantId());
			acsess.setLocalDateTime(LocalDateTime.now());
			acsess.setRestaurantId(rest.getRestaurantId());
			acsess.setUuid(RandomString.make(6));
			acsRepo.save(acsess);
			AdminLogin alog = new AdminLogin();
			alog.setAdminId(rest.getRestaurantId());
			alog.setPassword(rest.getPassword());
			alog.setRestaurantname(rest.getRestaurantName());
			alRepo.save(alog);
			return acsess.toString()+"  ... Loged In SuccessFully";
		}else {
			throw new LogInException("Invalid Credentials..");
		}
		
	}
	@Override
	public String AdminLogOut(String adminId) throws LogInException {
		AdminCurrentSession acs = acsRepo.findByUuid(adminId);
		if(acs==null) {
			throw new LogInException("Please LogIn First...");
		}
		acsRepo.delete(acs);
		Optional<AdminLogin> al = alRepo.findById(acs.getRestaurantId());
		alRepo.delete(al.get());
		return "Logged Out...";
	}


	
	
	
	

}
