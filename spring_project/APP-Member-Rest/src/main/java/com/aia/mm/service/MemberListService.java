package com.aia.mm.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mm.dao.MemberDao;
import com.aia.mm.model.Member;

@Service
public class MemberListService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public List<Member> getMemberList(){
		
		dao = sessionTemplate.getMapper(MemberDao.class);
		
		return dao.selectList();
	}

}
