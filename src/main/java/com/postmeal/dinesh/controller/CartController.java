package com.postmeal.dinesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.dinesh.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cs;

}
