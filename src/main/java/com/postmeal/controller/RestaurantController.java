package com.postmeal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Restaurant;
import com.postmeal.exception.ResturantNotFoundException;
import com.postmeal.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService rSer; 
	
	@PostMapping("/rest")
	ResponseEntity<Restaurant> addResturantHandler(@Valid @RequestBody Restaurant res){
		Restaurant r1=rSer.addResturant(res);
		return new ResponseEntity<Restaurant>(r1, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/uprest")
	ResponseEntity<Restaurant> updateResturantHandler(@Valid @RequestBody Restaurant res) throws ResturantNotFoundException{
		Restaurant upr=rSer.updateResturant(res);
		return new ResponseEntity<Restaurant>(upr,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/derest/{id}")
	ResponseEntity<Restaurant> removeResturantHandler(@PathVariable("id") Restaurant id) throws ResturantNotFoundException{
		Restaurant der=rSer.removeResturant(id);
		return new ResponseEntity<Restaurant>(der,HttpStatus.OK);
	}
	
	@GetMapping("/virest/{id}")
	ResponseEntity<Restaurant> viewResturantHandler(@PathVariable("id") Restaurant id) throws ResturantNotFoundException{
		Restaurant vir=rSer.viewResturant(id);
		return new ResponseEntity<Restaurant>(vir,HttpStatus.OK);
	}
	
	@GetMapping("/vnrest/{id}")
	ResponseEntity<Restaurant> viewNearByResturantHandler(@PathVariable("id") String id) throws ResturantNotFoundException{
		List<Restaurant> vnr=rSer.viewNearByResturant(id);
		return new ResponseEntity<Restaurant>(HttpStatus.OK);
	}
	
	@GetMapping("/vrest/{id}")
	ResponseEntity<Restaurant> viewResturantByItemNameHandler(@PathVariable("id") String id) throws ResturantNotFoundException{
		List<Restaurant> vrr=rSer.viewNearByResturant(id);
		return new ResponseEntity<Restaurant>(HttpStatus.OK);
	}
}