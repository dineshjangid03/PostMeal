package com.postmeal.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Restaurant;
import com.postmeal.exception.LogInException;
import com.postmeal.login.Repository.AdminCurrentSessionRepo;
import com.postmeal.login.Repository.AdminSignUpRepo;
import com.postmeal.login.model.AdminCurrentSession;
@Service
public class AdminCurrentSessServiceImpl implements AdminCurrentSessionService {
	@Autowired
	private AdminCurrentSessionRepo acsRepo;
	
//	@Autowired
//	private AdminSignUpRepo signRepo;
	
	
	@Override
	public AdminCurrentSession getCurrentAdminSession(String key) throws LogInException {
		AdminCurrentSession currAdminSes = acsRepo.findByUuid(key);
		if(currAdminSes==null) {
			throw new LogInException("Not Authorized");
		}
		return currAdminSes;
	}

	

}
