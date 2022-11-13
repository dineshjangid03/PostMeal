package com.postmeal.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Customer;
import com.postmeal.Model.FoodCart;
import com.postmeal.Model.Item;
import com.postmeal.exception.FoodCartException;
import com.postmeal.exception.ItemException;
import com.postmeal.repository.CartRepository;
import com.postmeal.repository.CustomerRepo;
import com.postmeal.repository.ItemRepository;



@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cr;
	
	@Autowired
	private ItemRepository ir;
	
	@Autowired
	private CustomerRepo cur;
	
	

	@Override
	public FoodCart saveFoodCart(FoodCart cart) {
		
		Optional<Customer> cust=cur.findById(cart.getCustomer().getCustomerId());
		
		if(cust.isPresent()) {
			cart.setCustomer(cust.get());
			return cr.save(cart);
		}
		return null;
		
	}
	

	@Override
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws FoodCartException, ItemException{
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> itm=ir.findById(itemId);
		
		if(!fc.isPresent()) {
			throw new FoodCartException("cart not found");
		}
		if(!itm.isPresent()) {
			throw new ItemException("item not found");
		}
		
		FoodCart cart=fc.get();
		Item item=itm.get();
		
		cart.getItemList().add(item);
		
		return cr.save(cart);
		
	}
	
	

	@Override
	public FoodCart viewCartById(Integer cartId) {
		Optional<FoodCart> optl=cr.findById(cartId);
		return optl.get();
	}
	
	
	@Override
	public FoodCart increaseQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> it=ir.findById(itemId);
		if(!it.isPresent()) {
			throw new ItemException("item not found");
		}
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			List<Item>list=fcart.getItemList();
			list.forEach(i->{
				if(i.equals(it.get())) {
					i.setQuantity(i.getQuantity()+quantity);
				}
			});
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}
	
	
	@Override
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		Optional<FoodCart> fc=cr.findById(cartId);
		Optional<Item> it=ir.findById(itemId);
		if(!it.isPresent()) {
			throw new ItemException("item not found");
		}
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			List<Item>list=fcart.getItemList();
			list.forEach(i->{
				if(i.equals(it.get())) {
					i.setQuantity(i.getQuantity()-quantity);
				}
			});
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}
	
	
	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException {
		Optional<FoodCart> fc=cr.findById(cartId);
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			fcart.getItemList().removeIf(x -> (x.getItemId()==itemId));
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}



	@Override
	public FoodCart clearCart(Integer cartId) throws FoodCartException {
		Optional<FoodCart> fc=cr.findById(cartId);
		if(fc.isPresent()) {
			FoodCart fcart=fc.get();
			fcart.getItemList().clear();;
			cr.save(fcart);
			return fcart;
		}
		throw new FoodCartException("cart not found");
	}


}
