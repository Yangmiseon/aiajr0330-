package com.aia.it.member.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.member.dao.MemberDaoInterface;

@Service
public class LogoutService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public boolean logout(HttpSession session) {
		
		
		session.invalidate();
		
		// 로그아웃 시 추가 작업 코드를 작성합니다.

		
		return true;
	}
}
