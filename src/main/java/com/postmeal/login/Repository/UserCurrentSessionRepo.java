package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.login.model.UserCurrentSession;
@Repository
public interface UserCurrentSessionRepo extends JpaRepository<UserCurrentSession, Integer> {
	public UserCurrentSession findByUuid(String uuid);
	public UserCurrentSession findByRestaurantId(Integer id);
	
}
