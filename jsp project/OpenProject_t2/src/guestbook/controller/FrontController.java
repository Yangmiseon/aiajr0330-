package guestbook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.service.NullServiceImpl;
import service.Service;



public class FrontController extends HttpServlet{
	
	private Map<String, Service> commands = new HashMap<String, Service>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		
		// 설정파일의 웹 경로
		String path = "/WEB-INF/command.properties";
		// 설정파일의 시스템 절대경로
		String configFile = config.getServletContext().getRealPath(path);
		
		
		try {
			fis = new FileInputStream(configFile);
			// 프로퍼티 객체로 파일을 읽어 온다.
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator();
				
		while(itr.hasNext()) {
			// 사용자 요청 URI
			String command = (String) itr.next();
			// 사용자 요청의 처리를 위한 클래스 이름, 정보
			String serviceClassName = prop.getProperty(command);
			
			try {
				// 인스턴스 생성을 위한 Class 객체
				Class serviceClass = Class.forName(serviceClassName);
				
				// 인스턴스 생성
				Service service = (Service) serviceClass.newInstance();
				
				commands.put(command, service);
				System.out.println(command + "=" + service );
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}


	private void processRequest(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String type = null;
		String command = request.getRequestURI();
		System.out.println(command);
		System.out.println(command.indexOf(request.getContextPath()));
		
		if(  command.indexOf(request.getContextPath()) == 0 ) {
			type = command.substring(request.getContextPath().length());
		}
		
		
		System.out.println("요청 파악 : " + type);
		

		Service service = commands.get(type);
		
		if(service == null) {
			service = new NullServiceImpl();
		}
		

		String page = service.getViewPage(request, response);
		
	
		// 5. 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
		
	}


	// 1. Http의 요청을 받는다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	
	
}