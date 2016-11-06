package com.justdoings.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.justdoings.member.model.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginPage(){
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void verifyLogin(){
		
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void updatePage(){
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateMember(){
		
	}
	
	@RequestMapping("logout")
	public void logout(){
		
	}
}
