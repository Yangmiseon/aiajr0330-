package com.app.op.member.dao;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.op.member.model.Member;

@Repository
public class MybatisMemberDao {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private String mapperPath="com.app.op.mybatis.mapper.MemberMapper";
	
	public int insertMember(Member member) {
				
		/*
		 * int result = 0;
		 * 
		 * result = sessionTemplate.update(mapperPath+".insertMember",member);
		 */
		
		return sessionTemplate.update(mapperPath+".insertMember",member);
	}

	/*
	 * //저장되어있는 전체 회원수 public int selectTotalCount(Connection conn) throws
	 * SQLException {
	 * 
	 * int resultCnt=0;
	 * 
	 * Statement stmt = null; ResultSet rs = null;
	 * 
	 * try {
	 * 
	 * stmt = conn.createStatement(); rs =
	 * stmt.executeQuery("select count(*) form project.member");
	 * 
	 * if(rs.next()) { resultCnt = rs.getInt(1); }
	 * 
	 * } finally { if(stmt != null) { stmt.close(); } }
	 * 
	 * 
	 * return resultCnt; }
	 * 
	 * //회원리스트 출력 public List<Member> selectList(Connection conn, int startRow, int
	 * count) throws SQLException {
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null;
	 * 
	 * List<Member> memberList = new ArrayList<Member>();
	 * 
	 * String sql = "select * from project.member order by uname limit ?,?";
	 * 
	 * try {
	 * 
	 * pstmt = conn.prepareStatement(sql); pstmt.setInt(1, startRow);
	 * pstmt.setInt(2, count);
	 * 
	 * rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) {
	 * 
	 * Member member = new Member(); member.setUidx(rs.getInt("uidx"));
	 * member.setUid(rs.getString("uid")); member.setUpw(rs.getString("upw"));
	 * member.setUname(rs.getString("uname"));
	 * member.setUphonenumber(rs.getString("uphonenumber"));
	 * member.setUphoto(rs.getString("uphoto"));
	 * member.setUregdate(rs.getDate("uregdate"));
	 * 
	 * memberList.add(member);
	 * 
	 * }
	 * 
	 * } finally { if(pstmt != null) { pstmt.close(); } }
	 * 
	 * return null; }
	 */

}
