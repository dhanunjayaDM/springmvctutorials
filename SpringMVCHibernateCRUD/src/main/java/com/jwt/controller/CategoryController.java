package com.jwt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Category;
import com.jwt.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") Category category, 
	   BindingResult result) {
	  categoryService.addCategory(category);
	  return new ModelAndView("redirect:/addCategory.html");
	 }
	 
	 @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	 public ModelAndView addCategory(@ModelAttribute("command")  Category category,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("categories",  categoryService.getCategories());
	  return new ModelAndView("addCategory", model);
	 }
	 
	 @RequestMapping(value = "/deleteCategory", method = RequestMethod.GET)
	 public ModelAndView deleteCategory(@ModelAttribute("command")  Category category,
	   BindingResult result) {
	  categoryService.deleteCategory(category.getCategoryId());
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("categories",  categoryService.getCategories());
	  return new ModelAndView("addCategory", model);
	 }
	 
	 @RequestMapping(value = "/editCategory", method = RequestMethod.GET)
	 public ModelAndView editCategory(@ModelAttribute("command")  Category category,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("category",  categoryService.getCategory(category.getCategoryId()));
	  model.put("categories",  categoryService.getCategories());
	  return new ModelAndView("addCategory", model);
	 }
	 
	 @RequestMapping(value="/categories", method = RequestMethod.GET)
	 public List<Category> getCategories() {
	  return categoryService.getCategories();
	 }

}
