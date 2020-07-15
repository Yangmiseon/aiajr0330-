package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberListView;
import service.Service;

public class MemberListServiceImpl implements Service {

MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		
		MemberListView memberListView = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			dao = MemberDao.getInstance();
			
			int totalCnt = dao.selectTotalCount(conn);
			
			final int MEMBER_COUNT_PER_PAGE=3;
			
			int currentPageNumber = 1;   // list.jsp?page=9
			String page = request.getParameter("page");
			if(page != null) {
				
				try {
					
					currentPageNumber = Integer.parseInt(page);
				
				} catch (NumberFormatException e) {
					System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
				}
			}

			
			int startRow =0;
			List<Member> memberList = null;
			
			if(totalCnt>0) {
				//시작 행, 마지막 행
				startRow = (currentPageNumber-1)*MEMBER_COUNT_PER_PAGE;
				
				memberList = dao.selectMemberList(conn, startRow,MEMBER_COUNT_PER_PAGE);
			}else {
				currentPageNumber = 0;
				memberList = Collections.emptyList();//컬렉션을 비어있는 객체로 받아줌
			}
			
			memberListView = new MemberListView(
					totalCnt, 
					currentPageNumber, 
					memberList, 
					MEMBER_COUNT_PER_PAGE, 
					startRow);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
						
		request.setAttribute("MemberlistView", memberListView);
		
		return "/member/memberList.jsp";
	}

}
