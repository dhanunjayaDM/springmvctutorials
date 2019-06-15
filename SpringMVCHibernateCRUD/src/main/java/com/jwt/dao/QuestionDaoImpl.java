package com.jwt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.Question;
@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override  @Transactional
	public Question getByQuestion_ID(int Question_ID) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, Question_ID);
	}

	@Override  @Transactional
	public List<Question> getAllQuestion() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Question.class);
		return criteria.list();
	}

	@Override  @Transactional
	public int save(Question question) {
		return (Integer) sessionFactory.getCurrentSession().save(question);
	}

	@Override  @Transactional
	public void update(Question question) {
		sessionFactory.getCurrentSession().merge(question);
	}

	@Override  @Transactional
	public void view(Question question) {
		sessionFactory.getCurrentSession().merge(question);
	}

	@Override  @Transactional
	public void delete(int Question_ID) {
		Question s = getByQuestion_ID(Question_ID);
		  sessionFactory.getCurrentSession().delete(s);
	}

}
