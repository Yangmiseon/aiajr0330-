package com.aia.it.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.it.planner.service.CalendarService;

@Controller
@RequestMapping("/planner/calendar")
public class CalendarController {
	
	@Autowired
	CalendarService calService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCalendarForm() {
		return "planner/calendarForm";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String getDate	 (	
			@RequestParam("datepicker") String startdate,
			@RequestParam("datepicker2") String enddate,
			Model model) {
		
		model.addAttribute("dateList", calService.getDateList(startdate, enddate));
		return "planner/plannerRegForm";
	}
}