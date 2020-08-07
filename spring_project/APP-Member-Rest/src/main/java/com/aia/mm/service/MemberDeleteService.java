package com.aia.mm.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.mm.dao.MemberDao;

@Service
public class MemberDeleteService {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public int deleteMember(int uidx) {
		
		dao = sessionTemplate.getMapper(MemberDao.class);
		
		return dao.deleteMember(uidx);
	}
	

}
