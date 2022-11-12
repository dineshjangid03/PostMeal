package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.postmeal.Model.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

	public Restaurant findByRestaurantName(String name);
}
