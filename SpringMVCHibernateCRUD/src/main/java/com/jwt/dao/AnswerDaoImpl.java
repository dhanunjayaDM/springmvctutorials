package com.jwt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.Answer;
@Repository
@Transactional
public class AnswerDaoImpl implements AnswerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override @Transactional
	public Answer getByAnswer_ID(int Answer_ID) {
		return (Answer) sessionFactory.getCurrentSession().get(Answer.class, Answer_ID);
	}

	@Override  @Transactional
	public List<Answer> getAllAnswer() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answer.class);
		  return criteria.list();
	}

	@Override  @Transactional
	public int save(Answer answer) {
		return (Integer) sessionFactory.getCurrentSession().save(answer);
	}

	@Override  @Transactional
	public void update(Answer answer) {
		sessionFactory.getCurrentSession().merge(answer);
	}

	@Override  @Transactional
	public void view(Answer answer) {
		sessionFactory.getCurrentSession().merge(answer);
	}

	@Override  @Transactional
	public void delete(int Answer_ID) {
		Answer s = getByAnswer_ID(Answer_ID);
		sessionFactory.getCurrentSession().delete(s);

	}

}
