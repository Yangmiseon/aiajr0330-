package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		System.out.println("WAS 종료");

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WAS 시작");
		
		ServletContext context = sce.getServletContext();
		String path = context.getInitParameter("uploadPath");
		
		String realPath = context.getRealPath(path);
		System.out.println(realPath);
		System.out.println("파일업로드경로: "+path);
	}

}