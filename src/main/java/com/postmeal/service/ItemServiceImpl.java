package com.postmeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Category;
import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.ItemException;
import com.postmeal.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository ir;

	@Override
	public Item addItem(Item item) {
		return ir.save(item);
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
		return itm.get();
	}

	@Override
	public Item deleteItem(Integer itemId) throws ItemException {
		Item it=ir.findById(itemId).get();
		ir.delete(it);
		return it;
	}

	@Override
	public List<Item> viewAllItemByCategory(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemByRestaurant(Restaurant res) {
		// TODO Auto-generated method stub
		return null;
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
