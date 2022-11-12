package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.login.model.AdminCurrentSession;

@Repository
public interface AdminCurrentSessionRepo extends JpaRepository<AdminCurrentSession, Integer> {
	public AdminCurrentSession findByRestaurantId(Integer adminId);
	
	public AdminCurrentSession findByUuid(String uuid);
}
