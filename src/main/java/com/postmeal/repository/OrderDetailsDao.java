package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.Model.OrderDetails;
@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
	

}
