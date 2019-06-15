package com.jwt.dao;

import java.util.List;

import com.jwt.model.Category;


public interface CategoryDao {
	void addCategory(Category category);
	List<Category> getCategories();
	Category getCategory(int categoryId);
	void deleteCategory(int categoryId);
	

}
