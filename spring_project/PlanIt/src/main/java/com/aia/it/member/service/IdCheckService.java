package com.aia.it.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.member.dao.MemberDaoInterface;


@Service
public class IdCheckService {

	private MemberDaoInterface dao;
	
	@Autowired 
	private SqlSessionTemplate sessionTemplate;
	

	public String checkId(String uid) {
		
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);

			String result = "N";

	

				int resultCnt = dao.selectById(uid);

				if (resultCnt < 1) {
					result = "Y";
				}

			
			return result;

	}

}
