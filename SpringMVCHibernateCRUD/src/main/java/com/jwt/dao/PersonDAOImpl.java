package com.jwt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.CreditCard;
import com.jwt.model.Person;
@Repository
public class PersonDAOImpl implements PersonDAO {
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Person> getAll() {
		  Session session = sessionFactory.getCurrentSession();
		  Query query = session.createQuery("FROM Person");
		  return  query.list();
		
	}

	@Override
	@Transactional
	public Person get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		   
		  // Retrieve existing person
		  // Create a Hibernate query (HQL)
		  Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);
		   
		  return (Person) query.uniqueResult();

	}

	@Override
	@Transactional
	public void add(Person person) {
		Session session = sessionFactory.getCurrentSession();
		   
		  // Persists to db
		session.save(person);

	}

	@Override
	@Transactional
	public void delete(Integer id) {
		System.out.println("begin");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+id);
		System.out.println(query);
		Person person = (Person) query.uniqueResult();
		System.out.println(person);
		List<CreditCard> creditCards =person.getCreditCards();
		System.out.println(creditCards);
		session.delete(person);
		for (CreditCard creditCard: creditCards) 
		{
		session.delete(creditCard);
		}
		

	}

	@Override
	@Transactional
	public void edit(Person person) {
		 Session session = sessionFactory.getCurrentSession();
		   
		  // Retrieve existing person via id
		  Person existingPerson = (Person) session.get(Person.class, person.getId());
		   
		  // Assign updated values to this person
		  existingPerson.setFirstName(person.getFirstName());
		  existingPerson.setLastName(person.getLastName());
		  existingPerson.setMoney(person.getMoney());
		 
		  // Save updates
		  session.save(existingPerson);
		

	}

}
