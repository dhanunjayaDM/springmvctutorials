package com.jwt.dao;

import java.util.List;

import com.jwt.model.Person;

public interface PersonDAO {
	 List<Person> getAll();
	 Person get( Integer id );
	 void add(Person person);
	 void delete(Integer id);
	 void edit(Person person);
}
