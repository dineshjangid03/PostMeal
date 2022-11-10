package com.postmeal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Category;
import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	public ResponseEntity<Item> addItem(Item item){
		return null;
	}
	
	public ResponseEntity<Item> updateItem(Item item){
		return null;
	}
	
	public ResponseEntity<Item> viewItem(Integer itemId){
		return null;
	}
	
	public ResponseEntity<Item> deleteItem(Integer itemId){
		return null;
	}
	
	public ResponseEntity<List<Item>> viewAllItemByCategory(Category cat){
		return null;
	}
	
	public ResponseEntity<List<Item>> viewAllItemByRestaurant(Restaurant res){
		return null;
	}
	
	public ResponseEntity<List<Item>> viewAllItemByName(String name){
		return null;
	}

}
