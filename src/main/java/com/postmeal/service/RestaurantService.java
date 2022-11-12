package com.postmeal.service;

import java.util.List;

import com.postmeal.Model.Restaurant;

import com.postmeal.exception.ResturantNotFoundException;

public interface RestaurantService {
	
	public Restaurant addResturant(Restaurant res)throws ResturantNotFoundException;
	
	public Restaurant updateResturant(Restaurant res)throws ResturantNotFoundException;
	
	public Restaurant removeResturant(Restaurant res)throws ResturantNotFoundException;
	
	public Restaurant viewResturant(Restaurant res)throws ResturantNotFoundException;
	
	public List<Restaurant> viewNearByResturant(String location)throws ResturantNotFoundException;
	
	public List<Restaurant> viewResturantByItemName(String name)throws ResturantNotFoundException;






}