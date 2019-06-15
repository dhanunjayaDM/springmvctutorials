package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Publication;
@Repository
public class PublicationDaoImpl implements PublicationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPublication(Publication publication) {
		sessionFactory.getCurrentSession().saveOrUpdate(publication);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Publication> getPublications() {
		// TODO Auto-generated method stub
		return (List<Publication>) sessionFactory.getCurrentSession().createCriteria(Publication.class).list();
	}

	@Override
	public Publication getPublication(int pubId) {
		// TODO Auto-generated method stub
		return (Publication) sessionFactory.getCurrentSession().get(Publication.class, pubId);
	}

	@Override
	public void deletePublication(int pubId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Publication WHERE pubId = "+pubId).executeUpdate();
	}

}
