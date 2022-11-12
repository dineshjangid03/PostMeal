package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.postmeal.model.FoodCart;

@Repository
public interface CartRepository extends JpaRepository<FoodCart, Integer>{

}
