package com.aia.it.planner.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.Planner;

@Service
public class PlannerRegService {
	
	private PlannerDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int plannerReg(Planner planner, HttpServletRequest request) {
		
		Date date = new Date(7, 5, 3);
		
		dao = sessionTemplate.getMapper(PlannerDaoInterface.class);
		
		int result = 0;
		
		result = dao.insertPlanner(planner);
		
		return result;
	}


}
