package com.dineshonjava.survey.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.survey.bean.Answer;

/**
 * @author Dinesh Rajput
 *
 */
@Repository
@Transactional
public class AnswerDAOImpl implements AnswerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#getByAnswer_ID(int)
	 */
	@Override
	public Answer getByAnswer_ID(int Answer_ID) {
		return (Answer) sessionFactory.getCurrentSession().get(Answer.class, Answer_ID);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#getAllAnswer()
	 */
	@Override
	public List<Answer> getAllAnswer() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answer.class);
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#save(com.dineshonjava.survey.bean.Answer)
	 */
	@Override
	public int save(Answer answer) {
		return (Integer) sessionFactory.getCurrentSession().save(answer);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#update(com.dineshonjava.survey.bean.Answer)
	 */
	@Override
	public void update(Answer answer) {
		sessionFactory.getCurrentSession().merge(answer);

	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#view(com.dineshonjava.survey.bean.Answer)
	 */
	@Override
	public void view(Answer answer) {
		sessionFactory.getCurrentSession().merge(answer);

	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.AnswerDAO#delete(int)
	 */
	@Override
	public void delete(int Answer_ID) {
		Answer s = getByAnswer_ID(Answer_ID);
		sessionFactory.getCurrentSession().delete(s);
	}

}
