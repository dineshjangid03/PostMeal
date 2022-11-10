package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
