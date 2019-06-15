package com.lara.dao;

import com.lara.beans.Login;
import com.lara.beans.User;

public interface UserDao {
	
	void register(User user);
	
	User validateUser(Login login);
	

}
