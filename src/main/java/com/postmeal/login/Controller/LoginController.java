package com.postmeal.login.Controller;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Customer;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.CurrentAdminSessException;
import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.CustomerException;
import com.postmeal.exception.LogInException;
import com.postmeal.exception.SignupException;
import com.postmeal.login.model.AdminLogin;
import com.postmeal.login.model.UserLogin;
import com.postmeal.login.service.LoginService;
import com.postmeal.login.service.SignUpService;

@RestController
@RequestMapping("/authr")
public class LoginController {
	@Autowired
	private LoginService lService;
	
	@Autowired
	private SignUpService signServ;
	
	@PostMapping("/userlogin")
	public ResponseEntity<String> userLoginHandler(@Valid @RequestBody UserLogin dto) throws LoginException, CurrentUserSessException, LogInException
	{
	String loginDone	=lService.loginUser(dto);
	return new ResponseEntity<String>(loginDone,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/userSignup")
	public ResponseEntity<Customer> userSignupHandler(@Valid @RequestBody Customer custo) throws SignupException, CurrentAdminSessException, CustomerException{
		
		Customer signUpSucess= signServ.UserSignUp(custo);
		
		return new ResponseEntity<Customer>(signUpSucess, HttpStatus.ACCEPTED);
	}
	@PostMapping("/adminLogin")
	public ResponseEntity<String> AdminLoginHandler(@Valid @RequestBody AdminLogin adminLogin ) throws LogInException, CurrentAdminSessException{
		
		String loginDone = lService.adminLogin(adminLogin);
		return new ResponseEntity<String>( loginDone, HttpStatus.ACCEPTED);
	}
	@PostMapping("/adminSignUp")
	public ResponseEntity<Restaurant> adminSignUpHandler(@Valid @RequestBody Restaurant rest) throws LogInException{
		
		Restaurant rests = signServ.AdminSigUpDetails(rest);
		
		return new ResponseEntity<Restaurant>(rests, HttpStatus.ACCEPTED);
	}
	@PostMapping("/userSignUp")
	public ResponseEntity<Customer> userSignUpHandler(@Valid @RequestBody Customer cust) throws CustomerException{
		Customer customer = signServ.UserSignUp(cust);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/adminUpdate/{key}")
	public ResponseEntity<Restaurant> adminUpdateHandler(@Valid @RequestBody Restaurant rest,@PathVariable("key") String key ) throws LogInException{
		
		Restaurant rests = signServ.updateAdminSignUpDetails(rest,key);
		
		return new ResponseEntity<Restaurant>(rests, HttpStatus.ACCEPTED);
	}
	@PostMapping("/userUpdate")
	public ResponseEntity<Customer> userUpdateHandler(@Valid @RequestBody Customer cust,@PathVariable("key") String key) throws CustomerException, LogInException, CurrentUserSessException{
		Customer customer = signServ.updateSignUpDetails(cust, key);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.ACCEPTED);
	}
	
	

}
