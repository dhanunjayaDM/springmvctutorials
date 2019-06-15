package com.jwt.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.Login;
import com.jwt.model.UserRegistration;
@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRegister(UserRegistration userRegistration) {
		sessionFactory.getCurrentSession().saveOrUpdate(userRegistration);

	}

	@Override
	public UserRegistration validateUser(Login login) {
		//sessionFactory.getCurrentSession().get(UserRegistration.class, (Serializable) login);
		System.out.println("email:"+login.getEmail());
		System.out.println("password:"+login.getPassword());
		System.out.println("userdao");
		System.out.println(sessionFactory.getCurrentSession().createSQLQuery("select * from user_registration where email='"+login.getEmail() +"' and password='"+login.getPassword()+ "'"));
		List<UserRegistration> userRegistration=this.sessionFactory.getCurrentSession().createSQLQuery("select * from user_registration where email='"+login.getEmail() +"' and password='"+login.getPassword()+ "'").addEntity(UserRegistration.class).list();
		if(userRegistration != null && userRegistration.size() > 0) {
			                System.out.println("Id= " + userRegistration.get(0).getId() + ", Name= " + userRegistration.get(0).getName() + ", Password= " + userRegistration.get(0).getPassword());
			                return userRegistration.get(0);
			            }
		return userRegistration.get(0);
		
	}

}
