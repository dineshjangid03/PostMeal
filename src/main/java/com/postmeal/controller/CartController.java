package com.postmeal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.FoodCart;
import com.postmeal.exception.FoodCartException;
import com.postmeal.exception.ItemException;
import com.postmeal.service.CartService;

@RestController
@RequestMapping("/foodcart")
public class CartController {
	
	@Autowired
	private CartService cs;
	
	
	@PostMapping("/add")
	public ResponseEntity<FoodCart> addNewCart(@RequestBody FoodCart cart){
		FoodCart newCart = cs.saveFoodCart(cart);
		return new ResponseEntity<FoodCart>(newCart, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/additem/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemsToCart(@PathVariable("cartId") Integer cartId, 
												   @PathVariable("itemId") Integer itemId) throws FoodCartException, ItemException{
		FoodCart updatedCart = cs.addItemToCart(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedCart,HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{cartId}")
	public ResponseEntity<FoodCart> viewById(@PathVariable("cartId") Integer cartId){
		FoodCart cart = cs.viewCartById(cartId);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	
	@PutMapping("/increasequantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") Integer cartId, 
													 @PathVariable("itemId") Integer itemId, 
													 @PathVariable("quantity") Integer quantity) throws FoodCartException, ItemException {
		FoodCart cart = cs.increaseQuantity(cartId, itemId, quantity);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/reducequantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> reduceQuantity(@PathVariable("cartId") Integer cartId, 
												   @PathVariable("itemId") Integer itemId, 
												   @PathVariable("quantity") Integer quantity) throws FoodCartException, ItemException {
		FoodCart cart = cs.reduceQuantity(cartId, itemId, quantity);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/removeitem/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> removeItem(@PathVariable("cartId") Integer cartId, 
			   								   @PathVariable("itemId") Integer itemId) throws FoodCartException {
		FoodCart updatedcart = cs.removeItem(cartId, itemId);
		return new ResponseEntity<FoodCart>(updatedcart, HttpStatus.OK);
	}
	
	@PutMapping("/clearcart/{cartId}")
	public ResponseEntity<FoodCart> clearCart(@PathVariable("cartId") Integer cartId) throws FoodCartException {
		FoodCart updatedcart = cs.clearCart(cartId);
		return new ResponseEntity<FoodCart>(updatedcart, HttpStatus.OK);
	}
	

}
