package com.postmeal.login.service;

import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.login.model.UserCurrentSession;

public interface UserCurrentSessionService {
	public UserCurrentSession getCurrentUserSession(String key) throws CurrentUserSessException;
	
}
