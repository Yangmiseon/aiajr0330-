package com.app.op.member;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.op.member.service.MemberListService;


@Controller
public class MemberListController {
	
	@Autowired
	MemberListService listService;
	
	
	@RequestMapping("/member/memberList")
	public String getMemberList(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response
			) throws SQLException {
		
		model.addAttribute("listView", listService.getView(request,response));
		return "member/memberList";
	}
}
