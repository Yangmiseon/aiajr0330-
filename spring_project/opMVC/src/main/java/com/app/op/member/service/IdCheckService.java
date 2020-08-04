package com.app.op.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.member.dao.JdbcTemplateMemberDao;

@Service
public class IdCheckService {
	
	@Autowired
	JdbcTemplateMemberDao dao;

	public String checkId(String uid) {

			String result = "N";

	

				int resultCnt = dao.selectById(uid);

				if (resultCnt < 1) {
					result = "Y";
				}

			
			return result;

	}

}
