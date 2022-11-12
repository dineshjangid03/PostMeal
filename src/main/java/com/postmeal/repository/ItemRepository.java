package com.postmeal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.postmeal.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	@Query("select i from Item i where i.ItemName=?1")
	public List<Item> findByName(String ItemName);

}
