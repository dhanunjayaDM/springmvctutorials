package com.lara.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lara.beans.Login;
import com.lara.beans.User;
import com.lara.dao.UserDao;
import com.lara.dao.UserDaoImpl;


@Controller
public class LoginController 
{
	  @Autowired
	  public UserDao  userDao;
	  
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView showLogin() {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	  }
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(@ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    User user = userDao.validateUser(login);
	    if (null != user) {
	    mav = new ModelAndView("welcome");
	    mav.addObject("firstname", user.getFirstname());
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }

}
