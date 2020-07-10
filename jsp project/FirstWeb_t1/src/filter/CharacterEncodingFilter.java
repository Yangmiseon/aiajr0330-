package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//init에서 만들고 doFilter에서 불러와 사용
public class CharacterEncodingFilter implements Filter {
	
	
	private String encodingType;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//필터컨피그에 있는 내용을 스트링타입으로 가져올수있음
		encodingType = filterConfig.getInitParameter("encoding");
		
		if(encodingType == null) {
			encodingType = "utf-8";
		}
	}
	

	@Override
	public void doFilter(ServletRequest request, 
						 ServletResponse response, 
						 FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encodingType);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
