package com.postmeal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postmeal.Model.Category;
import com.postmeal.exception.CategoryNotFoundException;
import com.postmeal.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private LoginService loginService;

	@Override
	public Category addCategory(Category cat) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Category cat) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category removeCategory(Category cat) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category viewCategory(Category cat) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
