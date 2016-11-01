package com.justdoings.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String welcome(){
		return "front/welcom.jsp";
	}
	
	
	@RequestMapping("/welcome")
	public ModelAndView welcome2(){
		return new ModelAndView("front/welcome");
	}
}
