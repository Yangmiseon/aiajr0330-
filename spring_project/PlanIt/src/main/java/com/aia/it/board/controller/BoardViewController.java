package com.aia.it.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.it.board.service.BoardViewService;

@Controller
public class BoardViewController {
	
	@Autowired
	private BoardViewService viewService;
	
	//사용자가 요청하는거 : http://localhost:8080/it/board/view/숫자
	@RequestMapping("/board/{bidx}")
	public String getBoardInfo(
			@PathVariable("bidx") int bidx,
			Model model) {
		
		model.addAttribute("viewBoard", viewService.getBoardInfo(bidx));
		
		return "board/boardView";
	}
	
	

}
