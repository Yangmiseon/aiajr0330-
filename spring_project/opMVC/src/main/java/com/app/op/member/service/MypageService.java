package com.app.op.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.member.dao.MemberDaoInterface;
import com.app.op.member.model.Member;

@Service
public class MypageService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public Member membermypage(String uid, HttpServletRequest request) {
		
		Member member= null;
			
			 member = dao.selectById(uid);			


		return member;
	}
}
