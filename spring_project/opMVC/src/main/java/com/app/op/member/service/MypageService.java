package com.app.op.member.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.member.dao.MemberDaoInterface;
import com.app.op.member.model.LoginInfo;
import com.app.op.member.model.Member;

@Service
public class MypageService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Autowired
	private MemberLoginService loginService;

	
	public Member getMemberInfo(String uid) {
		
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		return dao.selectById(LoginInfo.getUid());
		
	}

	

}
/*
 * 로그인 중인지 확인한다. 
 * 로그인된 아이디의 정보를 가져온다.
 * 로그인된 아이디를 기준으로 회원의 정보 (행1개)를 가져온다.
 * 가져온 데이터를 담는다.
 * 담아진 정보를 보여준다.
 */