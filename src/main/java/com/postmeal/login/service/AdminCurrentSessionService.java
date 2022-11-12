package com.postmeal.login.service;

import com.postmeal.exception.LogInException;
import com.postmeal.login.model.AdminCurrentSession;
import com.postmeal.model.Restaurant;

public interface AdminCurrentSessionService {
	
	public AdminCurrentSession getCurrentAdminSession(String key) throws LogInException;
	

}
