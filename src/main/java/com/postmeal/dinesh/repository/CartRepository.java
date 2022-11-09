package com.postmeal.dinesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.Model.FoodCart;

@Repository
public interface CartRepository extends JpaRepository<FoodCart, Integer>{

}
