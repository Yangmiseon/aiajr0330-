package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberListView;

public class GetMemberListService {
	
	//싱글톤처리
	private GetMemberListService() {}
	private static GetMemberListService service = new GetMemberListService();
	public static GetMemberListService getInstance() {
		return service;
	}

	private MemberDao dao;
	
	//한 페이지에 표현할 메시지의 개수(상수표현)
	private final int MEMBER_COUNT_PER_PAGE=3;
	
	public MemberListView getMemberList(int pageNumber) {
		//페이지 번호 > 시작 행, 끝 행
		//dao > List
		Connection conn = null;
		MemberListView memberListView = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			dao = MemberDao.getInstance();
			
			//페이지의 전체 메시지 구하기
			List<Member> memberList = null;
			
			//전체 메시지 개수
			int memberTotalCount = dao.selectTotalCount(conn);
			
			int startRow =0;
			
			if(memberTotalCount>0) {
				//시작 행, 마지막 행
				startRow = (pageNumber-1)*MEMBER_COUNT_PER_PAGE;
				
				memberList = dao.selectMemberList(conn, startRow);
			}else {
				pageNumber = 0;
				memberList = Collections.emptyList();//컬렉션을 비어있는 객체로 받아줌
			}
			
			memberListView = new MemberListView(
					memberTotalCount, 
					pageNumber, 
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
		
		return memberListView;
		
	}

	
}