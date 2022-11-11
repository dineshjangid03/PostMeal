package com.postmeal.loginController;

import javax.security.auth.login.LoginException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Customer;
import com.postmeal.exception.SignupException;
import com.postmeal.login.LoginDTO;
import com.postmeal.login.service.LoginService;

@RestController
@RequestMapping("/authr")
public class LoginController {
	@Autowired
	private LoginService lService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler(@Valid @RequestBody LoginDTO dto) throws LoginException
	{
	String loginDone	=lService.loginUser(dto);
	return new ResponseEntity<String>(loginDone,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signupHandler(@Valid @RequestBody Customer custo) throws SignupException
	{
		String signUpSucess= lService.signupUser(custo);
		
		return new ResponseEntity<String>(signUpSucess, HttpStatus.ACCEPTED);
	}

}
