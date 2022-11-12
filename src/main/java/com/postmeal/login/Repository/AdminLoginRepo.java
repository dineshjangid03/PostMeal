package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.login.model.AdminLogin;
@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLogin, Integer> {
	
	public AdminLogin findByRestaurantId(Integer name);

}
