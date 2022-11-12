package com.postmeal.controller;

import java.util.List;

import javax.xml.catalog.CatalogException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.postmeal.Model.Category;
import com.postmeal.exception.CategoryNotFoundException;
import com.postmeal.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService cSer;
	
	@PostMapping("/cat")
	ResponseEntity<Category> addCategoryHandler(@RequestBody Category cat){
		Category c1=cSer.addCategory(cat);
		return new ResponseEntity<Category>(c1,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/catup")
	ResponseEntity<Category> updateCategoryHandler(@RequestBody Category cat) throws CategoryNotFoundException{
		Category c2=cSer.addCategory(cat);
		return new ResponseEntity<Category>(c2,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/recat/{id}")
	ResponseEntity<Category> removeCategoryHandler(@PathVariable("id") Category id) throws CategoryNotFoundException{
		Category c3=cSer.removeCategory(id);
		return new ResponseEntity<Category>(c3,HttpStatus.OK);
	}
	
	@GetMapping("/vcat/{id}")
	ResponseEntity<Category> viewCategoryHandler(@PathVariable("id") Category id) throws CategoryNotFoundException{
		Category c4=cSer.viewCategory(id);
		return new ResponseEntity<Category>(c4,HttpStatus.OK);
	}
	
	@GetMapping("/vacat")
	ResponseEntity<Category> viewAllCategoryHandler() throws CategoryNotFoundException{
		List<Category> c5=cSer.viewAllCategory();
		return new ResponseEntity<Category>(HttpStatus.OK);
	}
}