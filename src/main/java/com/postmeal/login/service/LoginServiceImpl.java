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
		Customer customer = cRepo.findByEmail(dto.getUserName());
		if(customer==null) {
			throw new LogInException("Invalid Email...");
		}
		
		UserCurrentSession currUserOpt = userRepo.findByRestaurantId(customer.getCustomerId());
		if(currUserOpt != null) {
			throw new LogInException("User Already Logged In...");
		}
		if (customer != null && customer.getPassword().equals(dto.getPassword())&& customer.getEmail().equals(dto.getUserName())) {
			UserCurrentSession ucs = new UserCurrentSession();
			ucs.setLocalDateTime(LocalDateTime.now());
			ucs.setCustomerId(customer.getCustomerId());
			ucs.setUuid(RandomString.make(6));
			userRepo.save(ucs);
			UserLogin ulogin = new UserLogin(ucs.getCustomerId(), dto.getUserName(),dto.getPassword());
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
		userRepo.delete(ucs);
		Optional<UserLogin> ul = ulRepo.findById(ucs.getCustomerId());
		ulRepo.delete(ul.get());
		
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
		if(rest.getManagerName().equals(adminData.getRestaurantname()) && rest.getPassword().equals(adminData.getPassword())) {
			AdminCurrentSession acsess = new AdminCurrentSession();
			acsess.setLocalDateTime(LocalDateTime.now());
			acsess.setRestaurantId(rest.getRestaurantId());
			acsess.setUuid(RandomString.make(6));
			
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
		AdminLogin al = alRepo.findByRestaurantId(acs.getRestaurantId());
		alRepo.delete(al);
		return acs.toString()+"  "+"Logged Out...";
	}
	@Override
	public String signupUser(@Valid Customer custo) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	

}
