package com.postmeal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Restaurant;
import com.postmeal.exception.ResturantNotFoundException;
import com.postmeal.repository.ItemRepository;
import com.postmeal.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	@Autowired
	private RestaurantRepository rDao;
	
	@Autowired
	private ItemRepository iDao;
	
	

	@Override
	public Restaurant addResturant(Restaurant res) throws ResturantNotFoundException {
		if(res!=null) {
			return rDao.save(res);
			
		}
		else {
			 throw new ResturantNotFoundException("Resturant not added");
		}
		
	}

	@Override
	public Restaurant updateResturant(Restaurant res) throws ResturantNotFoundException {
		Optional<Restaurant> opt=rDao.findById(res.getRestaurantId());
		if(opt.isPresent()) {
			Restaurant res1=opt.get();
			res1.setRestaurantName(res.getRestaurantName());
			res1.setAddress(res.getAddress());
			res1.setManagerName(res.getManagerName());
			res1.setContactNumber(res.getContactNumber());
			res1.setItems(res.getItems());
			return rDao.save(res1);
			}else {
				throw new ResturantNotFoundException("Resturant not updated");
			}
		
	}

	@Override
	public Restaurant removeResturant(Restaurant res) throws ResturantNotFoundException {
		List<Restaurant> list = (List<Restaurant>) repository.findAll();
		return null;
	}

	@Override
	public Restaurant viewResturant(Restaurant res) throws ResturantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewNearByResturant(String location) throws ResturantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> viewResturantByItemName(String name) throws ResturantNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
