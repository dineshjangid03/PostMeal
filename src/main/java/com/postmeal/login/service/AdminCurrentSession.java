package com.postmeal.login.service;

import com.postmeal.exception.CurrentAdminSessException;
import com.postmeal.login.CurrentUserSession;

public interface AdminCurrentSession {
	public String adminCurrentSession(CurrentUserSession currSession) throws CurrentAdminSessException;
	

}
