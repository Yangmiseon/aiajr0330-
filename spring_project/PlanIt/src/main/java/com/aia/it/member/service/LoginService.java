package com.aia.it.member.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.member.dao.MemberDaoInterface;
import com.aia.it.member.model.LoginInfo;
import com.aia.it.member.model.LoginRequest;
import com.aia.it.member.model.Member;
import com.aia.it.member.util.CookieBox;

@Service
public class LoginService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;

	public int login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {
		
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		
		int result=0;
		
		//로그인 처리
		Member member = null;
		member= dao.selectByIdPw(loginRequest.getUid(), loginRequest.getUpw());
		
		System.out.println("로그인서비스의 member: "+member);
		
		if(member != null) {
			
			LoginInfo loginInfo = new LoginInfo(
					member.getUidx(),member.getUid(), member.getUname(), member.getUphoto());
			
			session.setAttribute("loginInfo", loginInfo);
			
			//쿠키 설정에 사용한 변수
			String cookieName = "uid";
			String cookiepath = session.getServletContext().getContextPath();

			// 회원 아이디 쿠키 설정
			if (loginRequest.getRemember() != null) {									
				response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 60 * 60 * 24 * 365));
			} else {
				response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 0));
			}

			// 로그인 이 필요했던 이전 페이지
			result=1;
		}

		return result;
	}

}
