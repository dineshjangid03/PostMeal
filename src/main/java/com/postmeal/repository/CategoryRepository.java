package com.postmeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postmeal.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
