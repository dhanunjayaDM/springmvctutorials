package com.dineshonjava.survey.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dineshonjava.survey.bean.Answer;
import com.dineshonjava.survey.bean.Question;
import com.dineshonjava.survey.bean.Survey;
import com.dineshonjava.survey.dao.AnswerDAO;
import com.dineshonjava.survey.dao.QuestionDAO;
import com.dineshonjava.survey.dao.SurveyDAO;
import com.dineshonjava.survey.utils.SurveyFormValidator;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class SurveyController {
	@Autowired
	private SurveyDAO surveyDAO;
	
	@Autowired
	private AnswerDAO answerDAO;
	
	@Autowired
	private QuestionDAO questionDAO;
	
	@Autowired
	private SurveyFormValidator validator;
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/viewAllSurvey")
	public ModelAndView getAllSurvey()
	{
		ModelAndView mav = new ModelAndView("showSurvey");
		List<Survey> survey = surveyDAO.getAllSurvey();
		mav.addObject("SEARCH_SURVEY_RESULTS_KEY", survey);
		return mav;
	}
	
	@RequestMapping(value="/saveSurvey", method=RequestMethod.GET)
	public ModelAndView newuserForm()
	{
		ModelAndView mav = new ModelAndView("newSurvey");
		Survey survey = new Survey();
		mav.getModelMap().put("newSurvey", survey);
		
		return mav;
	}
	
	@RequestMapping(value="/saveSurvey", method=RequestMethod.POST)
	public String create(@ModelAttribute("newSurvey")Survey survey, BindingResult result, SessionStatus status)
	{
		validator.validate(survey, result);
		if (result.hasErrors()) 
		{				
			return "newSurvey";
		}
		
		int surveyId = surveyDAO.save(survey);
		List<String> questions = survey.getQUESTION();
		Question ques = null;
		if(questions != null)
		{
			for(String question : questions)
			{
				ques = new Question();
				ques.setQUESTION(question);
				ques.setSurvey(survey);
				int quesId = questionDAO.save(ques);
				List<String> answers = survey.getAnswer();
				Answer answer = null;
				if(answers != null)
				{
					for(String ans : answers)
					{
						answer = new Answer();
						answer.setAnswer(ans);
						answer.setQuestion(ques);
						answerDAO.save(answer);
					}
				}
				
			}
		}
		status.setComplete();
		return "redirect:viewAllSurvey.do";
	}
	
	@RequestMapping(value="/updateSurvey", method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("SURVEY_ID")Integer SURVEY_ID)
	{
		ModelAndView mav = new ModelAndView("editSurvey");
		Survey survey = surveyDAO.getBySURVEY_ID(SURVEY_ID);
		mav.addObject("editSurvey", survey);
		return mav;
	}
	
	@RequestMapping(value="/updateSurvey", method=RequestMethod.POST)
	public String update(@ModelAttribute("editSurvey") Survey survey, BindingResult result, SessionStatus status)
	{
		validator.validate(survey, result);
		if (result.hasErrors()) {
			return "editSurvey";
		}
		surveyDAO.update(survey);
		status.setComplete();
		return "redirect:viewAllSurvey.do";
	}
	
	@RequestMapping(value="/viewSurvey", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam("SURVEY_ID")Integer SURVEY_ID)
	{
		ModelAndView mav = new ModelAndView("viewSurvey");
		Survey survey = surveyDAO.getBySURVEY_ID(SURVEY_ID);
		mav.addObject("viewSurvey", survey);
		return mav;
	}
}
