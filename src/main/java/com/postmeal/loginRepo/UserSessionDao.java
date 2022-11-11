package com.postmeal.loginRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postmeal.login.CurrentUserSession;

public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer> {
	

}
