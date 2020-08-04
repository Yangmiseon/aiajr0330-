package com.app.op.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.app.op.member.model.Member;
import com.app.op.member.model.MemberRegRequest;
import com.app.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberController {
	
	@Autowired
	MemberRegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberRegForm() {
		
		return "member/memberRegForm";
	}
	
	@RequestMapping( method=RequestMethod.POST)
	public String getMemberReg(
			MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			) throws IllegalStateException, IOException {
		
	
		System.out.println("controller : "+regRequest);
				
		model.addAttribute("result", regService.memberReg(regRequest, request));
		
		return "member/memberReg";
	}

}
