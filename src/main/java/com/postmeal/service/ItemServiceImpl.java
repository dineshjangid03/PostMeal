package com.postmeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.exception.CategoryNotFoundException;
import com.postmeal.exception.ItemException;
import com.postmeal.exception.ResturantNotFoundException;
import com.postmeal.Model.Category;
import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;
import com.postmeal.repository.CategoryRepository;

import com.postmeal.repository.ItemRepository;
import com.postmeal.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository ir;
	
	@Autowired
	private CategoryRepository cr;
	
	@Autowired
	private RestaurantRepository rr;

	@Override
	public Item addItem(Item item) {
		Optional<Category> cat= cr.findById(item.getCategory().getCatId());
		if(cat.isPresent()) {
			Category category=cat.get();
			item.setCategory(category);
			category.getItems().add(item);
			return ir.save(item);
		}
		
		return null;
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		Optional<Item> itm=ir.findById(item.getItemId());
		if(!itm.isPresent()) {
			throw new ItemException("item not found");
		}
		return ir.save(item);
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
		Optional<Item> itm=ir.findById(itemId);
		if(!itm.isPresent()) {
			throw new ItemException("item not found with id "+itemId);
		}
		return itm.get();
	}

	@Override
	public Item deleteItem(Integer itemId) throws ItemException {
		Optional<Item> it=ir.findById(itemId);
		if(!it.isPresent()) {
			throw new ItemException("item not found with id "+itemId);
		}
		Item itm=it.get();
		ir.delete(itm);
		return itm;
	}

	@Override
	public List<Item> viewAllItemByCategory(Integer catId) throws CategoryNotFoundException{
		Optional<Category> ct= cr.findById(catId);
		if(!ct.isPresent()) {
			throw new CategoryNotFoundException("category not found");
		}
		return ct.get().getItems();
	}

	@Override
	public List<Item> viewAllItemByRestaurant(Integer resId) throws ResturantNotFoundException{
		Optional<Restaurant> rs= rr.findById(resId);
		if(!rs.isPresent()) {
			throw new ResturantNotFoundException("restaurant not found");
		}
		return rs.get().getItems();
	}

	@Override
	public List<Item> viewAllItemByName(String name) throws ItemException {
		List<Item>list=ir.findByName(name);
		if(list.size()==0) {
			throw new ItemException("no items found with name "+name);
		}
		return list;
	}

	

}
