package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//인터페이스가 가지고 있는 추상메서드로 구현.
//필터만들고 웹점엑스엠엘에 등록해야함.
public class LoginFilter implements Filter {
	//핵심 필터 기능
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(//매개변수이름변경
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		//1. 현재 세션 객체를 확인
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		//현재 있으면 반환해주고, 없으면 널값. 트루는 무조건 새로운 세션을 만듬
		//현재 세션의 객체
		HttpSession session = httpRequest.getSession(false);
		
		//로그인 유무 확인 하는 변수
		//기본변수만들어두고 초기값을 설정해둠. 특정상황일때 데이터가 바뀌는 상황을 만들어 주면 코드가 많이 줄어들수있다.
		boolean login = false;
		//세션의 유무확인에 따라 로그인을 트루와 펄스바꿔준다.
		if(session!=null) {
			//로그인값을 트루로만드는 조건.
			//memberInfo의 속성값이 저장되어있느야없으냐가 중요. 널이아니면 로그인상태!
			if(session.getAttribute("memberInfo") !=null) {
				login = true;
			}
		}
		
		/*이렇게 줄일수있음.
		 * if(session!=null && session.getAttribute("memberInfo") !=null) {   
		 * login = true; 
		 * }
		 */
		//로그인이 참이거나 거짓이거나
		if(login) {//참이면
			chain.doFilter(request, response);
		}else {//메서드통해서 객체로 만들어 주는 구조
			//포워딩할 페이지 경로
			//포워드는 서버에서 처리하기때문에 컨테스트경로가 생기진않음. 하지만 리다이렉트는 사용자의 요청에 따라 보여지는 것이기 때문에 컨테스트경로가 필요함.
			/*
			 * String path ="/member/sessionLoginForm.jsp"; RequestDispatcher dispatcher =
			 * request.getRequestDispatcher(path); dispatcher.forward(request, response);
			 */
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			
			//""앞에 컨텍스트경로가필요함.
			String location = httpRequest.getContextPath()+ "/member/sessionLoginForm.jsp";
			httpResponse.sendRedirect(location);
		}
			
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
