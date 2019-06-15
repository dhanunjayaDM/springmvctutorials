package com.jwt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jwt.dao.CreditcardDAO;
import com.jwt.dao.PersonDAO;
import com.jwt.model.CreditCard;
import com.jwt.model.Person;

@Controller
@RequestMapping("/main/record")
public class PersonController {
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private CreditcardDAO creditCardDAO;
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public void setCreditCardDAO(CreditcardDAO creditCardDAO) {
		this.creditCardDAO = creditCardDAO;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getRecords(Model model) 
	{
    
	     // Retrieve all persons
	     List<Person> persons = personDAO.getAll();
	      
	     // Prepare model object
	     List<Person> personsDTO = new ArrayList<Person>();
	      
	     for (Person person: persons) 
	     {
		      // Create new data transfer object
		     Person dto = new Person();
		       
		     dto.setId(person.getId());
		     dto.setFirstName(person.getFirstName());
		     dto.setLastName(person.getLastName());
		     dto.setMoney(person.getMoney());
		     dto.setCreditCards((List<CreditCard>)creditCardDAO.getAll(person.getId()));
		    
		     // Add to model list
		     personsDTO.add(dto);
	     }
	      
	     // Add to model
	     model.addAttribute("persons", personsDTO);
	 
	     // This will resolve to /WEB-INF/jsp/records.jsp
	  return "records";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) 
	{
   
     // Create new Person and add to model
     model.addAttribute("personAttribute", new Person());
 
     // This will resolve to /WEB-INF/jsp/add-record.jsp
     return "add-record";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("personAttribute") Person person) 
	{
 
 
     // Delegate to service
	  personDAO.add(person);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
    }
	
	
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)
	 public String getDelete(@RequestParam("id") Integer personId)
	 {  
	     // Delete person
	  personDAO.delete(personId);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
	 }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)
	 public String getEdit(@RequestParam("id") Integer personId, Model model) {
	     
	      
	     // Retrieve person by id
	     Person existingPerson = personDAO.get(personId);
	 
	     // Add to model
	     model.addAttribute("personAttribute", existingPerson);
	 
	     // This will resolve to /WEB-INF/jsp/edit-record.jsp
	     return "edit-record";
	 }
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.POST)
	    public String postEdit(@RequestParam("id") Integer personId, 
	              @ModelAttribute("personAttribute") Person person) {
	  
	   
	  // Assign id
	  person.setId(personId);
	   
	  // Delegate to service
	  personDAO.edit(person);
	 
	  // Redirect to url
	  return "redirect:/main/record/list";
	 }

}
