package com.app.op.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.member.dao.MemberDaoInterface;
import com.app.op.member.model.Member;

@Service
public class MemberListJsonService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	//리스트 객체 반환해주기
	public List<Member> getMemberList(){
		
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		return dao.selectTotalList();
		
	}

}
