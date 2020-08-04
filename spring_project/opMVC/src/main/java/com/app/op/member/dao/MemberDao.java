package com.app.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.op.member.model.Member;

@Repository
public class MemberDao {
	
	public int insertMember(Connection conn, Member member) throws SQLException {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member(uid,upw,uname,uphonenumber,uphoto)VALUES(?,?,?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphonenumber());
			pstmt.setString(5, member.getUphoto());
			
			resultCnt = pstmt.executeUpdate();
			
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		return resultCnt;
	}

	//저장되어있는 전체 회원수 
	public int selectTotalCount(Connection conn) throws SQLException {

		int resultCnt=0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) form project.member");
			
			if(rs.next()) {
				resultCnt = rs.getInt(1);
			}
			
		} finally {
			if(stmt != null) {
				stmt.close();
		}
		}
				
		
		return resultCnt;
	}

	//회원리스트 출력
	public List<Member> selectList(Connection conn, int startRow, int count) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> memberList = new ArrayList<Member>();
		
		String sql = "select * from project.member order by uname limit ?,?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member member = new Member();
				member.setUidx(rs.getInt("uidx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphonenumber(rs.getString("uphonenumber"));
				member.setUphoto(rs.getString("uphoto"));
				member.setUregdate(rs.getDate("uregdate"));
				
				memberList.add(member);
				
			}

		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return null;
	}

}
