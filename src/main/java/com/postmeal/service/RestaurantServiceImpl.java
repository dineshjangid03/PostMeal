package com.postmeal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.catalog.CatalogException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Item;
import com.postmeal.Model.Restaurant;
import com.postmeal.exception.CategoryNotFoundException;
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
			return rDao.save(res);
			}else {
				throw new ResturantNotFoundException("Resturant not updated");
			}
		
	}

	@Override
	public Restaurant removeResturant(Restaurant res) throws ResturantNotFoundException {

		Optional<Restaurant> opt=rDao.findById(res.getRestaurantId());
		if(opt.isPresent()) {
			rDao.delete(opt.get());
			return opt.get();
		}else {
			throw new ResturantNotFoundException("Resturant not removed"+res.getRestaurantId());
		}

	}

	@Override
	public Restaurant viewResturant(Restaurant res) throws ResturantNotFoundException {
		Optional<Restaurant> ob = rDao.findById(res.getRestaurantId());
		
		if(ob.isPresent()) {
			return ob.get();
		}
		else {
		
		throw new ResturantNotFoundException("Can Not View Resturant");
		
		}
	}

	@Override
	public List<Restaurant> viewNearByResturant(String location) throws ResturantNotFoundException {
		List<Restaurant> list=new ArrayList<>();
		list=rDao.findAll();
		List<Restaurant> list1=new ArrayList<>();
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				if(location.equalsIgnoreCase(list.get(i).getRestaurantName())) {
					list1.add(list.get(i));
				
				}
			}
			return list;
			
		}
		else {
			throw new CategoryNotFoundException("Restaurant not found in :"+location);
		}
	}

	@Override
	public List<Restaurant> viewResturantByItemName(String name) throws ResturantNotFoundException {
		List<Restaurant> list=new ArrayList<>();
		list=rDao.findAll();
		List<Restaurant> list1=new ArrayList<>();
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				List<Item> items=list.get(i).getItems();
				for(int j=0;j<items.size();j++) {
					if(name.equalsIgnoreCase(items.get(j).getItemName())) {
						list1.add(list.get(i));
			
//						break;
				}
			}
			}
			return list;
			
		}
		else {
			throw new CategoryNotFoundException("Restaurant not found in :"+name);
		}
	}
		
}