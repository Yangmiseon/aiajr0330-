package com.aia.it.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.it.member.service.LogoutService;

@Controller
public class LogoutController {

	@Autowired
	private LogoutService logoutService;

	@RequestMapping("/login/logout")
	public String logout(
			HttpSession session
			) {
		
		
		//session.invalidate();
		logoutService.logout(session);
		
		//String viewName = "member/logout";//
		//String viewName ="redirect:/login/logout";

				
				
		
		return "member/logout";
	}
}
