package com.app.op.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.op.member.service.MemberViewService;

@Controller
public class MemberViewController {
	
	
	//@Autowired 이거나 Inject이걸로 통일하기. 의존관계설정
	@Autowired
	private MemberViewService viewService;
	
	
	//사용자가 요청하는거 : http://localhost:8080/op/member/view/12
	@RequestMapping("/member/view/{uidx}")
	public String getMemberInfo(
			@PathVariable("uidx") int uidx,
			Model model
			) {
		
		model.addAttribute("viewMember", viewService.getMemberInfo(uidx));
		return "member/memberView";
	}

}
