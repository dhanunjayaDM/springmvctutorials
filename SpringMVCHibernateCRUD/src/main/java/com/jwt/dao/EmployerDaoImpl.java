package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employer;
@Repository
public class EmployerDaoImpl implements EmployerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployer(Employer employer) 
	{
		System.out.println("dao");
		sessionFactory.getCurrentSession().persist(employer);

	}

}
