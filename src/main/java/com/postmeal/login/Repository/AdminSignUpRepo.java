package com.postmeal.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.model.Restaurant;
@Repository
public interface AdminSignUpRepo extends JpaRepository<Restaurant, Integer> {
	public Restaurant findByRestaurantName(String name);
	
}
