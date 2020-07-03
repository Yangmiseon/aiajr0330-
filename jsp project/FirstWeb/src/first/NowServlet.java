package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/now")
public class NowServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int total = 0;
		 
		for (int cnt = 1; cnt < 101; cnt++)
		 
		total += cnt;
		 
		PrintWriter out = response.getWriter();
		 
		out.println( "<HTML> ");
		 
		out.println( "<HEAD><TITLE>더하기다아</TITLE> ");
		
		out.println( "</HEAD> ");
		 
		out.println( "<BODY> ");
		out.println( "<div id=contanar> ");
		out.println( "<div id=\"maintitle\"> BITUUR</div>");
		out.println( "<a href=\"main.html\" id=\"startbtn\">start</a> ");
		out.println( "</div>");
		 
		out.printf( "1 + 2 + 3 + ... + 100 = %d ", total);
		 
		out.println( "</BODY> ");
		 
		out.println( "</HTML> ");

	}


}
