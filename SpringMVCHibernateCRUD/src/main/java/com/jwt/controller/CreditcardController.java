package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jwt.dao.CreditcardDAO;
import com.jwt.model.CreditCard;

@Controller
@RequestMapping("/main/creditcard")
public class CreditcardController 
{
	@Autowired
	private CreditcardDAO creditCardDAO;
	
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String getAdd(@RequestParam("id") Integer personId, Model model) {
	    
	     
	     // Prepare model object
	     CreditCard creditCard = new CreditCard();
	      
	     // Add to model
	     model.addAttribute("personId", personId);
	     model.addAttribute("creditCardAttribute", creditCard);
	 
	     // This will resolve to /WEB-INF/jsp/add-credit-card.jsp
	     return "add-credit-card";
	 }
	 
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	 public String postAdd(@RequestParam("id") Integer personId, 
	              @ModelAttribute("creditCardAttribute") CreditCard creditCard) 
	 {
	  
	   
	  // Delegate to service
	  creditCardDAO.add(personId, creditCard);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
	 }
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public String getDelete(@RequestParam("id") Integer creditCardId) {
	      
	     // Delegate to service
	     creditCardDAO.delete(creditCardId);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
	 }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	 public String getEdit(@RequestParam("pid") Integer personId, 
	      @RequestParam("cid") Integer creditCardId, Model model) {
	 
	     // Retrieve credit card by id
	     CreditCard existingCreditCard = creditCardDAO.get(creditCardId);
	 
	     // Add to model
	     model.addAttribute("personId", personId);
	     model.addAttribute("creditCardAttribute", existingCreditCard);
	 
	     // This will resolve to /WEB-INF/jsp/edit-credit-card.jsp
	     return "edit-credit-card";
	 }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	 public String postEdit(@RequestParam("id") Integer creditCardId, 
	              @ModelAttribute("creditCardAttribute") CreditCard creditCard) {
	 
	  // Assign id
	  creditCard.setId(creditCardId);
	   
	  // Delegate to service
	  creditCardDAO.edit(creditCard);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
	 }

}
