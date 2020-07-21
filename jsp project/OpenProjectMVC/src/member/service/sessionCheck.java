package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.Service;

public class sessionCheck implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		String page = null;
		// 1. 현재 세션 객체를 확인
		HttpServletRequest httpRequest = (HttpServletRequest)request;
				
		// 현재 세션의 객체
		HttpSession session = httpRequest.getSession(false);
				
		// 로그인 유무 확인 하는 변수
		boolean login = false;
				
		if(session != null ) {
			if(session.getAttribute("sessionID") != null) {
				login = true;
			}
		}
				
		if(login) {
					
			page = "/WEB-INF/views/member/mypage.jsp";
					
		} else {
					
			// 포워딩할 페이지 경로
			//String path = "/member/sessionLoginForm.jsp";
			//RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			//dispatcher.forward(request, response);
					
					
			page = "/WEB-INF/views/member/loginRegForm.jsp";					
					
		}
		
		
		
		return "/WEB-INF/views/member/sessionCheck.jsp";
	}

}
