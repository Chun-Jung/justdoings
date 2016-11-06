package com.justdoings.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.justdoings.member.model.LoginDTO;
import com.justdoings.member.model.Member;
import com.justdoings.member.model.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginPage(WebRequest webRequest){
		Object obj = webRequest.getAttribute("memSession", WebRequest.SCOPE_SESSION);
		if(obj != null){
			return "front/welcome";
		}
		return "front/member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String verifyLogin(WebRequest webRequest, LoginDTO loginDTO){
		Member member = memberService.findByEmail(loginDTO.getEmail());
		if(member != null){
			if(member.getPassword().equals(loginDTO.getPassword())){
				webRequest.setAttribute("memberSession", member, WebRequest.SCOPE_SESSION);
//				String requestURL = (String) webRequest.getAttribute("requestURL", WebRequest.SCOPE_REQUEST);
				return "redirect:front/welcome";
			}
		}
		return "redirect:front/member/login";
	}
	
	@RequestMapping(value = "forgetPassword", method = RequestMethod.GET)
	public String forgetPasswordPage(){
		return "front/member/forget.jsp";
	}
	
	@RequestMapping(value = "forgetPassword", method = RequestMethod.POST)
	public void sendUpdatePasswordMail(){
		
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void updatePage(){
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateMember(){
		
	}
	
	@RequestMapping("logout")
	public void logout(){
		
	}
}
