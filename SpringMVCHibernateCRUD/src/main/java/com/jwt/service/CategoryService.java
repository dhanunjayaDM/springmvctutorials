package com.jwt.service;

import java.util.List;

import com.jwt.model.Category;

public interface CategoryService {
	void addCategory(Category category);
	List<Category> getCategories();
	Category getCategory(int categoryId);
	void deleteCategory(int categoryId);

}
