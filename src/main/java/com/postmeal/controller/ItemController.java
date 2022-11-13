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

import com.postmeal.Model.Category;
import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.ItemException;
import com.postmeal.exception.ResturantNotFoundException;
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
	
	@PutMapping("/addItemInRestaurant/{itemId}/{resId}")
	public ResponseEntity<Item> addItemInRestaurant(@PathVariable("itemId") Integer itemId,@PathVariable("resId") Integer resId) throws ItemException,ResturantNotFoundException{
		Item updated=is.addItemInRestaurant(itemId, resId);
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
	
	@GetMapping("/viewitembycategory/{catId}")
	public ResponseEntity<List<Item>> viewAllItemByCategory(@PathVariable("catId") Integer catId){
		List<Item>list=is.viewAllItemByCategory(catId);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewitembyrestaurant/{resId}")
	public ResponseEntity<List<Item>> viewAllItemByRestaurant(@PathVariable("resId") Integer resId){
		List<Item>list=is.viewAllItemByRestaurant(resId);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewallitembyname/{name}")
	public ResponseEntity<List<Item>> viewAllItemByName(@PathVariable("name")String name) throws ItemException{
		List<Item>list=is.viewAllItemByName(name);
		return new ResponseEntity<List<Item>>(list, HttpStatus.ACCEPTED);
	}

}
