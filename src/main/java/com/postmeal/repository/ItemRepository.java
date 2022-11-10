package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postmeal.Model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
