package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import guestbook.model.MessageListView;
import jdbc.ConnectionProvider;

public class GetMessageListService {
	
	//싱글톤처리
	private GetMessageListService() {}
	private static GetMessageListService service = new GetMessageListService();
	public static GetMessageListService getInstance() {
		return service;
	}

	private MessageDao dao;
	
	//한 페이지에 표현할 메시지의 개수(상수표현)
	private final int MESSAGE_COUNT_PER_PAGE=3;
	
	public MessageListView getMessageList(int pageNumber) {
		//페이지 번호 > 시작 행, 끝 행
		//dao > List
		Connection conn = null;
		MessageListView messageListView = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			dao = MessageDao.getInstance();
			
			//페이지의 전체 메시지 구하기
			List<Message> messageList = null;
			
			//전체 메시지 개수
			int messageTotalCount = dao.selectTotalCount(conn);
			
			int startRow =0;
			
			if(messageTotalCount>0) {
				//시작 행, 마지막 행
				startRow = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE;
				
				messageList = dao.selectMessageList(conn, startRow);
			}else {
				pageNumber = 0;
				messageList = Collections.emptyList();//컬렉션을 비어있는 객체로 받아줌
			}
			
			messageListView = new MessageListView(
					messageTotalCount, 
					pageNumber, 
					messageList, 
					MESSAGE_COUNT_PER_PAGE, 
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
		
		return messageListView;
		
	}

	
}