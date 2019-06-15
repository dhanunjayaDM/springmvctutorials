package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.CategoryDao;
import com.jwt.model.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	@Transactional
	public void addCategory(Category category) {
		categoryDao.addCategory(category);

	}

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDao.getCategories();
	}

	@Override
	@Transactional
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDao.getCategory(categoryId);
	}

	@Override
	@Transactional
	public void deleteCategory(int categoryId) {
		categoryDao.deleteCategory(categoryId);

	}

}
