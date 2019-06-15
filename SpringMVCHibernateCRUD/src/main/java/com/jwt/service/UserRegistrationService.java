package com.jwt.service;

import java.util.List;

import com.jwt.model.Login;
import com.jwt.model.UserRegistration;

public interface UserRegistrationService {
	public void addUser(UserRegistration userRegistration);
	
	public UserRegistration validateUser(Login login);

}
