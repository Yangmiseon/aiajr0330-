package com.aia.it.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.it.board.model.BoardRequest;
import com.aia.it.board.service.BoardWriteService;
import com.aia.it.member.service.MemberListService;

@Controller
@RequestMapping("/board/boardWrite")
public class BoardWriteController {
	
	@Autowired
	BoardWriteService writeService;
	
	@Autowired
	private MemberListService listService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getBoardForm(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		model.addAttribute("memberListView", listService.getview(request, response));

		return "board/boardWriteForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String getBoard(
			BoardRequest bRequest, 
			HttpServletRequest request, 
			Model model) {
		
		System.out.println("controller: "+bRequest);
		
		model.addAttribute("result" , writeService.boardWrite(bRequest, request));
		
		return "board/boardWrite";
		
	}
	
	
}

