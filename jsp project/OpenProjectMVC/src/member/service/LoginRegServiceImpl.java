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

public class LoginRegServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		String context=request.getContextPath();
		response.setContentType("text/html; charset=UTF-8");
		Member sessionmember = new Member();
		 
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String page = "/WEB-INF/views/member/loginReg.jsp";
		Connection conn = null;
		
		int resultCnt = 0;
		

		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			//dao.userCheck 메서드에서 받은 리턴값을 이용하여 분기
			resultCnt = dao.userCheck(uid, upw, conn);
			
			//1이나오면 로그인성공!! 정보가 1개 있다는 뜻. 마이페이지로 보냄
			//######추후 다른 곳으로 보낼수도 있음!
			if(resultCnt == 1) {
				HttpSession session = request.getSession();

				request.setAttribute("resultCnt", resultCnt);
				session.setAttribute("sessionID", uid);
				page = "/WEB-INF/views/member/mypage.jsp";
			}
			//1이 아니면 모두 로그인실패. 로그인페이지로 돌아감.
			else if(resultCnt < 1){
				request.setAttribute("resultCnt", resultCnt);
				page = "/WEB-INF/views/member/loginRegForm.jsp";
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
       
		return page;
	}

}
