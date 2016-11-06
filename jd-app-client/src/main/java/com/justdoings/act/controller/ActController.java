package com.justdoings.act.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.justdoings.act.model.ActService;
import com.justdoings.ad.model.AdService;

@Controller
@RequestMapping("/act")
public class ActController {
	@Autowired
	private ActService actService;
	
	@Autowired
	private AdService adService;
	
	@RequestMapping("/findPage")
	public ModelAndView findActPage(){
		//TODO:導回找活動頁面
		ModelAndView model = new ModelAndView("/front/welcome");
		model.addObject("adList", adService.findEffectAct());
		return model;
	}
	
	@RequestMapping("/create")
	public String createActPage(){
		//TODO:導向建立活動頁面，理應配合filter進行會員登入驗證
		return "";
	}
}
