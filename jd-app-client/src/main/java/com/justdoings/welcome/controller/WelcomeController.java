package com.justdoings.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.justdoings.act.model.ActService;
import com.justdoings.ad.model.AdService;

@Controller
public class WelcomeController {
	@Autowired
	private AdService adService;
	
	@Autowired
	private ActService actService;
	
	@RequestMapping("/*")
	public ModelAndView defalutPage(){
		return welcomePage();
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcomePage(){
		ModelAndView model = new ModelAndView("front/welcome");
		model.addObject("adList", adService.findEffectAd());
		return model;
	}
}
