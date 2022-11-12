package com.postmeal.login.service;

import com.postmeal.Model.Restaurant;
import com.postmeal.exception.LogInException;
import com.postmeal.login.model.AdminCurrentSession;

public interface AdminCurrentSessionService {
	
	public AdminCurrentSession getCurrentAdminSession(String key) throws LogInException;
	

}
