package com.springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		
		return "index";
	}
	@RequestMapping("/about")
	public String About(Model model) {
		model.addAttribute("name","Dharmendra");
		List<String> student = new ArrayList<String>();
		student.add("Bikash");
		student.add("suresh");
		model.addAttribute("student",student);
		return "about";
	}
	@RequestMapping("/help")
	public ModelAndView help() {
		
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.addObject("name","Dear");
		modelAndview.setViewName("help");
		LocalDateTime now = LocalDateTime.now();
		modelAndview.addObject("now",now);
		return modelAndview;
		
	}
	
	@RequestMapping("/search")
	public RedirectView getSearchEngine(
			
			@RequestParam("query") String query
			 
			) {
		RedirectView rv= new RedirectView();
		String url="https://www.google.com/search?q="+query;
		rv.setUrl(url);
		
		return rv;
	}
	@RequestMapping("")
	public String getSearch() {
		return "searchEngine";
	}
	

}
