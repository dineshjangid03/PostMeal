package com.postmeal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Category;
import com.postmeal.exception.CategoryNotFoundException;
import com.postmeal.login.service.LoginService;
import com.postmeal.repository.CategoryRepository;
import com.postmeal.repository.RestaurantRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
//	@Autowired
//	private RestaurantRepository restaurantDao;
//	
//	@Autowired
//	private LoginService loginService;

	@Override
	public Category addCategory(Category cat) throws CategoryNotFoundException {
		if(cat!=null) {
			return categoryRepo.save(cat);
		}
		else {
			throw new CategoryNotFoundException("Category not found...");
		}
	}

	@Override
	public Category updateCategory(Category cat) throws CategoryNotFoundException {
		Optional<Category> oc=categoryRepo.findById(cat.getCatId());
		if(oc.isPresent()) {
			return categoryRepo.save(cat);
		}
		else {
			throw new CategoryNotFoundException("Category not updated...");
		}
	}

	@Override
	public Category removeCategory(Category cat) throws CategoryNotFoundException {
		Optional<Category> opt=categoryRepo.findById(cat.getCatId());
		if(opt.isPresent()) {
			categoryRepo.delete(opt.get());
			return opt.get();
		}
		else {
			throw new CategoryNotFoundException("Category not deleted...");
		}
	}

	@Override
	public Category viewCategory(Category cat) throws CategoryNotFoundException {
		Optional<Category> oc=categoryRepo.findById(cat.getCatId());
		if(oc.isPresent()) {
			return oc.get();
		}
		else {
			throw new CategoryNotFoundException("Category can not view...");
		}
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryNotFoundException {
		List<Category> list=new ArrayList<>();
		list=categoryRepo.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new CategoryNotFoundException("Category of list is empty");
		}
	}
	
	
}
