package com.jwt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.CreditCard;
import com.jwt.model.Person;
@Repository
public class CreditcardDAOImpl implements CreditcardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	@Transactional
	public List<CreditCard> getAll(Integer personId) {
		Session session = sessionFactory.getCurrentSession(); 
		  // Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Person as p LEFT JOIN FETCH  p.creditCards WHERE p.id="+personId);   
		Person person = (Person) query.uniqueResult();
		   
		  // Retrieve all
		return  new ArrayList<CreditCard>(person.getCreditCards());
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CreditCard> getAll() {
		Session session = sessionFactory.getCurrentSession();
		   
		  // Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM  CreditCard");
		   
		  // Retrieve all
		return  query.list();
	}

	@Override
	@Transactional
	public CreditCard get(Integer id) {
		Session session = sessionFactory.getCurrentSession();  
		  // Retrieve existing credit card
		CreditCard creditCard = (CreditCard) session.get(CreditCard.class, id);  
		  // Persists to db
		return creditCard;
	}

	@Override
	@Transactional
	public void add(Integer personId, CreditCard creditCard) {
		 Session session = sessionFactory.getCurrentSession();
		  
		  // Persists to db
		  session.save(creditCard);
		   
		  // Add to person as well
		  // Retrieve existing person via id
		  Person existingPerson = (Person) session.get(Person.class, personId);
		   
		  // Assign updated values to this person
		  existingPerson.getCreditCards().add(creditCard);
		 
		  // Save updates
		  session.save(existingPerson);
	
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		   
	     // Delete reference to foreign key credit card first
	  // We need a SQL query instead of HQL query here to access the third table
	     Query query = session.createSQLQuery("DELETE FROM PERSON_CREDIT_CARD " +
	       "WHERE creditCards_ID="+id);
	      
	     query.executeUpdate();
	      
	  // Retrieve existing credit card
	  CreditCard creditCard = (CreditCard) session.get(CreditCard.class, id);
	   
	  // Delete 
	  session.delete(creditCard);
	
		
	}

	@Override
	@Transactional
	public void edit(CreditCard creditCard) {
		Session session = sessionFactory.getCurrentSession();
		   
		  // Retrieve existing credit card via id
		  CreditCard existingCreditCard = (CreditCard) session.get(CreditCard.class, creditCard.getId());
		   
		  // Assign updated values to this credit card
		  existingCreditCard.setNumber(creditCard.getNumber());
		  existingCreditCard.setType(creditCard.getType());
		 
		  // Save updates
		  session.save(existingCreditCard);
	
		
	}

}
