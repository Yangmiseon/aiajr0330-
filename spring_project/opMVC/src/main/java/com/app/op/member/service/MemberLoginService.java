package com.app.op.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.app.op.member.dao.MemberDaoInterface;
import com.app.op.member.model.LoginInfo;
import com.app.op.member.model.LoginRequest;
import com.app.op.member.model.Member;
import com.app.op.util.CookieBox;

@Service
public class MemberLoginService {
	
	
	//인터페이스가 아닌 구현체를 주입해야하니까 세션템플릿을 주입함
	//JdbcTemplateMemberDao dao;
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public String login(
			LoginRequest loginRequest, 
			HttpSession session, 
			HttpServletResponse response) {
		
		//interface 의 Mapper 객체 생성
		dao = sessionTemplate.getMapper(MemberDaoInterface.class);
		
		String loginResult = "";


		// 로그인 처리
		Member member = null;

			member = dao.selectByIdpw(loginRequest.getUid(), loginRequest.getUpw());

			System.out.println("LoginService Member : " + member);

			if (member != null) {

				LoginInfo loginInfo = new LoginInfo(member.getUid(), member.getUname(), member.getUphoto());

				session.setAttribute("loginInfo", loginInfo);

				// 쿠키 설정에 사용한 변수
				String cookieName = "uid";
				String cookiepath = session.getServletContext().getContextPath();
				System.out.println("너의 정보는?????????????? : " + cookiepath);
				// 회원 아이디 쿠키 설정
				if (loginRequest.getRemember() != null) {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 60 * 60 * 24 * 365));
				} else {
					response.addCookie(CookieBox.createCookie(cookieName, loginRequest.getUid(), cookiepath, 0));
				}

				// 로그인 이 필요했던 이전 페이지
				loginResult = "<script>" + "alert('로그인되었습니다.');" + "location.href='" + loginRequest.getRedirecUri() + "'" + "</script>";

			} else {
				loginResult = "<script>" + "alert('아이디 또는 비밀번호가 틀립니다.');" + "history.go(-1);" + "</script>";
			}

		return loginResult;

	}
	


}
