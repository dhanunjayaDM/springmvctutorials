package com.dineshonjava.survey.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.survey.bean.Question;

/**
 * @author Dinesh Rajput
 *
 */
@Repository
@Transactional
public class QuestionDAOImpl implements QuestionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#getByQuestion_ID(int)
	 */
	@Override
	public Question getByQuestion_ID(int Question_ID) {
		return (Question) sessionFactory.getCurrentSession().get(Question.class, Question_ID);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#getAllQuestion()
	 */
	@Override
	public List<Question> getAllQuestion() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Question.class);
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#save(com.dineshonjava.survey.bean.Question)
	 */
	@Override
	public int save(Question question) {
		return (Integer) sessionFactory.getCurrentSession().save(question);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#update(com.dineshonjava.survey.bean.Question)
	 */
	@Override
	public void update(Question question) {
		sessionFactory.getCurrentSession().merge(question);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#view(com.dineshonjava.survey.bean.Question)
	 */
	@Override
	public void view(Question question) {
		sessionFactory.getCurrentSession().merge(question);
	}

	/* (non-Javadoc)
	 * @see com.dineshonjava.survey.dao.QuestionDAO#delete(int)
	 */
	@Override
	public void delete(int Question_ID) {
		Question s = getByQuestion_ID(Question_ID);
		sessionFactory.getCurrentSession().delete(s);
	}

}
