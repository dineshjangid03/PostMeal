package com.postmeal.dinesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.FoodCart;
import com.postmeal.Model.Item;
import com.postmeal.dinesh.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cs;
	
	
	
	public FoodCart addItemToCart(FoodCart cart, Item item) {
		return null;
	}
	
	
	
	public FoodCart increaseQuantity(FoodCart cart, Item item, Integer quantity) {
		return null;
	}
	
	
	
	public FoodCart reduceQuantity(FoodCart cart, Item item, Integer quantity) {
		return null;
	}
	
	
	
	public FoodCart removeItem(FoodCart cart, Item item) {
		return null;
	}
	
	
	
	public FoodCart clearCart(FoodCart cart) {
		return null;
	}

}
