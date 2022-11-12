package com.postmeal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.exception.ItemException;
import com.postmeal.model.Category;
import com.postmeal.model.Item;
import com.postmeal.model.Restaurant;
import com.postmeal.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService is;
	
	@PostMapping("/additem")
	public ResponseEntity<Item> addItem(@RequestBody Item item){
		Item saved=is.addItem(item);
		return new ResponseEntity<Item>(saved, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException{
		Item updated=is.updateItem(item);
		return new ResponseEntity<Item>(updated, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewitem/{id}")
	public ResponseEntity<Item> viewItem(@PathVariable("id") Integer itemId) throws ItemException{
		Item item=is.viewItem(itemId);
		return new ResponseEntity<Item>(item, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable("id") Integer itemId) throws ItemException{
		Item deleted=is.deleteItem(itemId);
		return new ResponseEntity<Item>(deleted, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Item>> viewAllItemByCategory(Category cat){
		List<Item>list=is.viewAllItemByCategory(cat);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<List<Item>> viewAllItemByRestaurant(Restaurant res){
		List<Item>list=is.viewAllItemByRestaurant(res);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewallitembyname/{name}")
	public ResponseEntity<List<Item>> viewAllItemByName(@PathVariable("name")String name) throws ItemException{
		List<Item>list=is.viewAllItemByName(name);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}

}
