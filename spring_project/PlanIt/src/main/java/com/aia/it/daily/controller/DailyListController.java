package com.aia.it.daily.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.it.daily.service.DailyListService;

@Controller
@RequestMapping("/planner/dailyList")
public class DailyListController {

	
	
		
		@Autowired
		private DailyListService listService;
		
		@RequestMapping(method = RequestMethod.POST)
		public String getBoardList(
				@RequestParam("uidx") int uidx,
					Model model, int pidx
					) {
			
			System.out.println(uidx);
			model.addAttribute("listView", listService.getView(uidx,pidx));
			
			return "planner/plannerRegForm";
			
		}
			
	
	
	
	
	
	
}
