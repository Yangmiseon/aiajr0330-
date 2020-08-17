package com.aia.it.planner.dao;

import com.aia.it.planner.model.Planner;

public interface PlannerDaoInterface {

	int insertPlanner(Planner planner);

	Planner plannerJoinDaily(int uidx);

}
