package com.jwt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.model.Survey;
@Repository
@Transactional
public class SurveyDaoImpl implements SurveyDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override  @Transactional
	public Survey getBySURVEY_ID(int SURVEY_ID) {
		
		return (Survey) sessionFactory.getCurrentSession().get(Survey.class, SURVEY_ID);
	}

	@Override  @Transactional
	public List<Survey> getAllSurvey() {
		
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Survey.class);
		return criteria.list();
	}

	@Override  @Transactional
	public int save(Survey survey) {
		return (Integer) sessionFactory.getCurrentSession().save(survey);
	}

	@Override  @Transactional
	public void update(Survey survey) {
		sessionFactory.getCurrentSession().merge(survey);
	}

	@Override  @Transactional
	public void view(Survey survey) {
		sessionFactory.getCurrentSession().merge(survey);
	}

	@Override  @Transactional
	public void delete(int SURVEY_ID) {
		Survey s = getBySURVEY_ID(SURVEY_ID);
		sessionFactory.getCurrentSession().delete(s);	
	}

}
