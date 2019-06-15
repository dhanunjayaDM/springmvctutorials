package com.jwt.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.jwt.dao.AnswerDao;
import com.jwt.dao.QuestionDAO;
import com.jwt.dao.SurveyDao;
import com.jwt.model.Answer;
import com.jwt.model.Question;
import com.jwt.model.Survey;

@Controller
public class SurveyController 
{
	@Autowired
	private SurveyDao surveyDAO;
	 
	@Autowired
	private AnswerDao answerDAO;
	 
	@Autowired
	private QuestionDAO questionDAO;
	

	/*@Autowired
	private SurveyFormValidator validator;*/
	 
	@RequestMapping("/home1")
	 public String home()
	 {
	  return "home1";
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
	 List<Question> questions = new ArrayList<>();
	  Question q = new Question();
	 
	  List<String> answers = new ArrayList<String>(4);
	 
//	   Answer answer1 = new Answer();
//	   Answer answer3 = new Answer();
//	   Answer answer2 = new Answer();
//	   Answer answer4 = new Answer();
	   answers.add("");
	   answers.add("");
	   answers.add("");
	   answers.add("");
	   q.setAnswers(answers);
	  questions.add(q);
	  Question q1 = new Question();
	  questions.add(q1);
	  Question q3 = new Question();
	  questions.add(q3);
	   survey.setQuestions(questions);
	 System.out.println(  survey.getQuestions().get(0).getAnswers().size());
	  mav.getModelMap().put("newSurvey", survey);
	  return mav;
	 }
	 
	 @RequestMapping(value="/saveSurvey", method=RequestMethod.POST)
	 public String create(@ModelAttribute("newSurvey")Survey survey, BindingResult result, SessionStatus status)
	 {
	  /*validator.validate(survey, result);*/
	  if (result.hasErrors()) 
	  {    
	   return "newSurvey";
	  }
	  
	  int surveyId = surveyDAO.save(survey);
	  System.out.println(surveyId);
		List<Question> questions = survey.getQuestions();
		Question ques = null;
		if(questions != null)
		{
			for(Question question : questions)
			{
//				ques = new Question();
//				ques.setQUESTION(question);
//				ques.setSurvey(survey);
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
	 /* validator.validate(survey, result);*/
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
