package com.postmeal.login.service;

import javax.security.auth.login.LoginException;

import com.postmeal.Model.Customer;
import com.postmeal.exception.CurrentAdminSessException;
import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.SignupException;
import com.postmeal.login.LoginDTO;

public interface LoginService {
	
	public String loginUser(LoginDTO dto) throws LoginException,CurrentUserSessException;
	public String signupUser(Customer custo) throws SignupException,CurrentAdminSessException;


}
