package com.postmeal.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.postmeal.Model.Item;
import com.postmeal.exception.CategoryNotFoundException;
import com.postmeal.exception.ItemException;
import com.postmeal.exception.ResturantNotFoundException;

public interface ItemService {
	
	public Item addItem(Item item);
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item addItemInRestaurant(Integer itemId,@PathVariable("resId") Integer resId) throws ItemException,ResturantNotFoundException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item deleteItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItemByCategory(Integer catId) throws CategoryNotFoundException;
	
	public List<Item> viewAllItemByRestaurant(Integer resId) throws ResturantNotFoundException;
	
	public List<Item> viewAllItemByName(String name)throws ItemException;

}
