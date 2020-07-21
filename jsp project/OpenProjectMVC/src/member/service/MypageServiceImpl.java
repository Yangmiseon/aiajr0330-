package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import service.Service;

public class MypageServiceImpl implements Service {
	
	MemberDao dao;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
	
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession(false);
		
		
		String uid = (String)session.getAttribute("sessionID");
		System.out.println("세션정보다아!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+uid);
		
		Connection conn = null;
		Member member = null;
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			
			member = dao.userInfo(uid, conn);
			request.setAttribute("member", member);
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/WEB-INF/views/member/mypage.jsp";
	}

}
