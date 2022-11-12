package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.login.model.UserLogin;
@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer>{
	
	
}
