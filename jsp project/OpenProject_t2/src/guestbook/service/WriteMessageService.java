package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;

public class WriteMessageService {
	
	private WriteMessageService () {
	}
	
	
	private static WriteMessageService service = new WriteMessageService();
	
	public static WriteMessageService getInstance() {
		
		return service;
	}
	
	//dao필요
	MessageDao dao = null;

	//된다안된다는 카운트로 반환
	public int writeMessage(Message message) {
		
		int result=0;
		dao = MessageDao.getInstance();
		
		//Dao의 메서드에 전달할 Connection 
		Connection conn = null;
		
		try {
			conn= ConnectionProvider.getConnection();
		
			result = dao.insertMessage(conn, message);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}
}
