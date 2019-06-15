package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Category;
@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		

	}

	@Override
	public List<Category> getCategories() {
		
		return (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
	}

	@Override
	public void deleteCategory(int categoryId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM category WHERE categoryId = "+categoryId).executeUpdate();

	}

}
