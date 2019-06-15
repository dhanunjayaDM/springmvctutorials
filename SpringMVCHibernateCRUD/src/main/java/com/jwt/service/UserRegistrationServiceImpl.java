package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.UserRegistrationDao;
import com.jwt.model.Login;
import com.jwt.model.UserRegistration;
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	private UserRegistrationDao userRegistrationDao;

	@Override @Transactional
	public void addUser(UserRegistration userRegistration) {
		userRegistrationDao.addRegister(userRegistration);
		

	}

	@Override @Transactional
	public UserRegistration validateUser(Login login) {
		System.out.println("userservice");
		return userRegistrationDao.validateUser(login);
	}

}
