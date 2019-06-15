package com.jwt.dao;

import java.util.List;

import com.jwt.model.Login;
import com.jwt.model.UserRegistration;

public interface UserRegistrationDao {
	public void addRegister(UserRegistration userRegistration);
	public UserRegistration validateUser(Login login);

}
