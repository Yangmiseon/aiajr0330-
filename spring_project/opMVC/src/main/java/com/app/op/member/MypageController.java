package com.app.op.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.op.member.service.MypageService;


@Controller
public class MypageController {

	@Autowired
	MypageService mypageService;
	
	@RequestMapping("/member/mypage")
	public String getMypageView(
				Model model,
				HttpServletRequest request,
				@RequestParam("uid") String uid
			) {
		
		model.addAttribute("memberInfo", mypageService);
		return "member/mypage";
	}
}
