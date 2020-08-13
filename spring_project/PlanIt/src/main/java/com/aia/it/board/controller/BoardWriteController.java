package com.aia.it.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.it.board.model.BoardRequest;
import com.aia.it.board.service.BoardWriteService;

@Controller
public class BoardWriteController {
	
	@Autowired
	BoardWriteService writeService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getBoardForm() {
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
