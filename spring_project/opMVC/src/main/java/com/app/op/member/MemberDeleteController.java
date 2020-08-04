package com.app.op.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.op.member.service.MemberDeleteService;
import com.app.op.member.service.MemberEditService;

@Controller
public class MemberDeleteController {
	
	
	@Autowired
	MemberDeleteService deleteService;
	

	@RequestMapping("/member/memberDelete")
	public String deleteMember(
			@RequestParam("uidx") int uidx,
			HttpServletRequest request,
			Model model 
			) {
		
		model.addAttribute("msg", deleteService.memberDelete(uidx, request));
		
		return "member/memberDelete";
	}

}
