package com.lara.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lara.beans.Login;
import com.lara.beans.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public void register(User user) {
		String sql="insert into user values(?,?,?,?,?,?,?)";
		jdbctemplate.update(sql, new Object[] {user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getAddress(),user.getPhone()});

	}

	@Override
	public User validateUser(Login login) {
		String sql="select * from user where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'";
		List<User> users=jdbctemplate.query(sql, new UserrowMapper());
		
		return users.size()>0 ? users.get(0):null;
	}

}
