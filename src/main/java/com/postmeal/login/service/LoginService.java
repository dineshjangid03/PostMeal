package com.postmeal.login.service;

import javax.validation.Valid;

import com.postmeal.exception.CurrentAdminSessException;
import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.exception.LogInException;
import com.postmeal.exception.SignupException;
import com.postmeal.login.model.AdminLogin;
import com.postmeal.login.model.UserLogin;
import com.postmeal.model.Customer;

public interface LoginService {
	
	public String loginUser(UserLogin dto) throws LogInException,CurrentUserSessException;
	
	public String userLogOut(String uuid) throws LogInException;
	
	public String adminLogin(AdminLogin adminData) throws LogInException, CurrentAdminSessException; 
	
	public String AdminLogOut(String adminId) throws LogInException;

	public String signupUser(@Valid Customer custo);


}
