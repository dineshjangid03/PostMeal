package com.postmeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.repository.CartRepository;



@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cr;

}
