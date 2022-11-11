package com.postmeal.loginRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postmeal.exception.CurrentUserSessException;
import com.postmeal.login.CurrentUserSession;
import com.postmeal.login.service.UserCurrentSession;

public interface UserCurreSession extends JpaRepository<CurrentUserSession, Integer> {

	
}
