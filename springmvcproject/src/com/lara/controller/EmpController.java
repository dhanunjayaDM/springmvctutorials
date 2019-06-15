package com.lara.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lara.beans.Emp;
import com.lara.dao.EmpDAO;
import com.lara.report.PdfEmpListReportView;

@Controller
public class EmpController {
    @Autowired
    public EmpDAO dao;
    
	@RequestMapping(value="/empform", method = RequestMethod.GET)
	public ModelAndView showform(){
		return new ModelAndView("empform");
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Emp emp){
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");//will redirect to viewemp request mapping
	}
	
	@RequestMapping("/viewemp")
	public ModelAndView viewemp(){
		List<Emp> list=dao.getEmployees();
		return new ModelAndView("viewemp","list",list);
	}
	
	@RequestMapping(value="/editemp/{id}")
	public ModelAndView edit(@PathVariable int id){
		Emp emp=dao.getEmpById(id);
		return new ModelAndView("empeditform","command",emp);
	}
	
	@RequestMapping(value="/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Emp emp){
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp");
	}
	
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id){
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");
	}
	
	 @RequestMapping(value="/report", method=RequestMethod.GET)
	 public ModelAndView userListReport(){
		  
		  
		  List<Emp> list=dao.getEmployees();
		  
		  //if(typeReport != null && typeReport.equals("xls")){
//			   return new ModelAndView(new ExcelUserListReportView(), "userList", list);
//			  } else if()
			
			   return new ModelAndView(new PdfEmpListReportView(), "list", list);
			
		  
		  
	 }
	 
	/* @RequestMapping(value="/excelreport", method=RequestMethod.GET)
	 public ModelAndView empListReport(){
		  
		  
		  List<Emp> list=dao.getEmployees();
		  
		  //if(typeReport != null && typeReport.equals("xls")){
//			   return new ModelAndView(new ExcelUserListReportView(), "userList", list);
//			  } else if()
			
			   return new ModelAndView(new ExcelEmpListReportView(), "list", list);
			
		  
		  
	 }*/

}
