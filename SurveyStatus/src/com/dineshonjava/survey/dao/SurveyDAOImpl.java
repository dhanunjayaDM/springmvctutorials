package com.dineshonjava.survey.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.survey.bean.Survey;

/**
 * @author Dinesh Rajput
 *
 */
@Repository
@Transactional
public class SurveyDAOImpl implements SurveyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Survey getBySURVEY_ID(int SURVEY_ID)
	{
		return (Survey) sessionFactory.getCurrentSession().get(Survey.class, SURVEY_ID);
	}
	
	@SuppressWarnings("unchecked")
	public List<Survey> getAllSurvey()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Survey.class);
		return criteria.list();
	}
		
	public int save(Survey survey)
	{
		return (Integer) sessionFactory.getCurrentSession().save(survey);
	}
	
	public void update(Survey survey)
	{
		sessionFactory.getCurrentSession().merge(survey);
	}
	
		
	public void view(Survey survey)
	{
		sessionFactory.getCurrentSession().merge(survey);
	}
	
	public void delete(int SURVEY_ID)
	{
		Survey s = getBySURVEY_ID(SURVEY_ID);
		sessionFactory.getCurrentSession().delete(s);
	}
}
