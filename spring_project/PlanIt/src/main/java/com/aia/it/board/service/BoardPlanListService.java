package com.aia.it.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.member.model.LoginRequest;
import com.aia.it.planner.dao.PlannerDaoInterface;
import com.aia.it.planner.model.Planner;

@Service
public class BoardPlanListService {
		
	private PlannerDaoInterface pdao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Planner BoardPlanList(
			LoginRequest loginRequest,
			int uidx) {
		
		pdao=sessionTemplate.getMapper(PlannerDaoInterface.class);
		
		Planner planner = null;
		
		planner = pdao.plannerJoinDaily(loginRequest.getUidx());
		
		return planner;
	}

}
