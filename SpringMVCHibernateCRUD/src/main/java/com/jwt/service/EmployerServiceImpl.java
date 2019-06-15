package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.EmployerDao;
import com.jwt.model.Employer;
@Service
public class EmployerServiceImpl implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;

	@Override 
	@Transactional
	public void addEmployeer(Employer employer) {
		System.out.println("service");
		employerDao.addEmployer(employer);
		
	}

}
