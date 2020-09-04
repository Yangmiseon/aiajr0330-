package com.aia.it.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aia.it.daily.service.DailyListService;
import com.aia.it.planner.model.PlannerJoinDaily;

@RestController
@RequestMapping("/board/boardWriteForm")
public class BoardListRestController {
	
	@Autowired
	private DailyListService listDailyService;
	
	@GetMapping
	public List<PlannerJoinDaily> getBoardForm(
			@RequestParam("uidx") int uidx,
			@RequestParam("pidx") int pidx
			) {
		
		return listDailyService.getView(uidx, pidx);
	}

}
