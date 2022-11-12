package com.postmeal.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.login.Repository.UserCurrentSessionRepo;
import com.postmeal.login.model.UserCurrentSession;
@Service
public class UserCurrentSessionImpl implements UserCurrentSessionService {
	@Autowired
	private UserCurrentSessionRepo ucS;
	@Override
	public UserCurrentSession getCurrentUserSession(String key) throws CurrentUserSessException{
		UserCurrentSession ucs = ucS.findByUuid(key);
		if(ucS==null) {
			throw new CurrentUserSessException("Seesion does not esist");
		}
		return ucS.save(ucs);
	}

}
