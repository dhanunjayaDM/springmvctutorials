package com.lara.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.lara.beans.User;

public class UserrowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getInt("phone"));
		return user;
	}

	

}
