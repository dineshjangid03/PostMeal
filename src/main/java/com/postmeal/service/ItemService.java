package com.postmeal.service;

import java.util.List;

import com.postmeal.exception.ItemException;
import com.postmeal.model.Category;
import com.postmeal.model.Item;
import com.postmeal.model.Restaurant;

public interface ItemService {
	
	public Item addItem(Item item);
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item deleteItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItemByCategory(Category cat);
	
	public List<Item> viewAllItemByRestaurant(Restaurant res);
	
	public List<Item> viewAllItemByName(String name)throws ItemException;

}
