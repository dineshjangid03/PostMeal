package com.postmeal.service;

import com.postmeal.exception.FoodCartException;
import com.postmeal.exception.ItemException;
import com.postmeal.model.FoodCart;
import com.postmeal.model.Item;

public interface CartService {
	
	public FoodCart saveFoodCart(FoodCart cart);
	
	public FoodCart addItemToCart(Integer cart, Integer item)throws FoodCartException, ItemException;
	
	public FoodCart viewCartById(Integer cartId);
	
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException , ItemException;
	
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException , ItemException;
	
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException ;
	
	public FoodCart clearCart(Integer cartId) throws FoodCartException ;

}
