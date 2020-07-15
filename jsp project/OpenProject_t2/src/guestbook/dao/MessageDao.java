package guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;


public class MessageDao {

	private MessageDao() {
	}
	
	static private MessageDao dao = new MessageDao();
	
	public static MessageDao getInstance() {
		return dao;
	}

	public int insertMessage(Connection conn, Message message) throws SQLException{
		
		int resultCnt =0;
		
	 
		PreparedStatement pstmt = null;	
		
		try {
			String sql = "INSERT INTO project.op_guestbook(uname, pw, Message)VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getUname());
			pstmt.setString(2, message.getPw());
			pstmt.setString(3, message.getMessage());
		
			resultCnt=pstmt.executeUpdate();
		} finally {
			
			if(pstmt != null) {
				
				pstmt.close();
			}
			
			
			
		}
		
		return resultCnt;
	}

	public List<Message> selectMessageList(Connection conn, int startRow) throws SQLException{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Message> list = new ArrayList();
		
try {
			
			String sql = "SELECT * FROM project.op_guestbook limit ?, 3;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Message message = new Message(
										rs.getInt("idx"),
										rs.getString("uname"),
										rs.getString("pw"),//굳이 패스워드받을이유없음
										rs.getString("message"));
				list.add(message);
			}
			
		} finally {
			
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return list;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		
		int resultCnt = 0;

		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.createStatement();
			
			//카운트를 구해오는 sql문 필요
			String sql = "select count(*) from project.op_guestbook";
			rs = stmt.executeQuery(sql);
			
			//행하나받기
		
			if(rs.next()) {
				resultCnt = rs.getInt(1);				
			}
		}finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt !=null) {
				stmt.close();
			}
		}
		
		return resultCnt;
	}

	public Message selectMessage(Connection conn, int idx) throws SQLException {
		Message message = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from project.op_guestbook where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				message = new Message(
						rs.getInt("idx"),
						rs.getString("uname"),
						rs.getString("pw"),
						rs.getString("message"));
			}
		
		}finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return message;
	}

	public int deleteMessage(Connection conn, int idx) throws SQLException {

		int resultCnt =0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from project.op_guestbook where idx=?";
		
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		
		resultCnt = pstmt.executeUpdate();
				
	}finally {
		if(pstmt != null) {
			pstmt.close();
		}
	}
		return resultCnt;
}






	
	  
	 
}
