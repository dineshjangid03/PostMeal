package com.postmeal.service;

import java.util.List;

import com.postmeal.Model.Category;
import com.postmeal.exception.CategoryNotFoundException;

public interface CategoryService {
	
	public Category addCategory(Category cat)throws CategoryNotFoundException;
	
	public Category updateCategory(Category cat)throws CategoryNotFoundException;
	
	public Category removeCategory(Category cat)throws CategoryNotFoundException;
	
	public Category viewCategory(Category cat)throws CategoryNotFoundException;
	
	public List<Category> viewAllCategory()throws CategoryNotFoundException;
}
