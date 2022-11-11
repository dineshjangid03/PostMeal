package com.postmeal.service;

import java.util.List;


import com.postmeal.Model.Category;
import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.ItemException;

public interface ItemService {
	
	public Item addItem(Item item);
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item deleteItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItemByCategory(Category cat);
	
	public List<Item> viewAllItemByRestaurant(Restaurant res);
	
	public List<Item> viewAllItemByName(String name)throws ItemException;

}
