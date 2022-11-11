package com.postmeal.login.service;

import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.login.CurrentUserSession;

public interface UserCurrentSession {
	
	public String userCurrentSession(CurrentUserSession currUsSession) throws CurrentUserSessException;
	
	

}
