package com.app.op.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.op.member.model.Member;

@Repository
public class JdbcTemplateMemberDao {
	
	@Inject
	JdbcTemplate jdbcTemplate;
	
	
	
	
	public int insertMember(Member member) {
		
		String sql = "INSERT INTO project.member(uid,upw,uname,uphonenumber,uphoto)VALUES(?,?,?,?,?)";
		
		return jdbcTemplate.update(sql, member.getUid(), member.getUpw(), member.getUname(), member.getUphonenumber(), member.getUphoto());
	}
	
	
	
	public Member selectByIdx(int uidx) {
		
		Member member = null;
		
	
		String sql = "select * from project.member where uidx=?";
			
		member = jdbcTemplate.queryForObject(sql, new MemberRowMapper(),uidx);
		
		return member;
	}
	
	
	
	public int editMember(Member member) throws SQLException {
		
		int result = 0;
		
		
		String sql = "update project.member set upw=?, uname=?, uphonenumber=?, uphoto=? where uidx=?";
		
		
		return jdbcTemplate.update(sql, member.getUpw(), member.getUname(), member.getUphonenumber(), member.getUphoto(), member.getUidx());

	}



	public int selectTotalCount() throws SQLException {
		
		/*
		 * int resultCnt = 0; 
		 * String sql= "select count(*) from project.member";
		 * 
		 * resultCnt=jdbcTemplate.queryForObject(sql, Integer.class);
		 * 
		 * return resultCnt;
		 */
		
		return jdbcTemplate.queryForObject("select count(*) from project.member",Integer.class);
	}

	
	
	public List<Member> selectList(int startRow, int count) throws SQLException {
		
		
		/*
		 * List<Member> memberList = new ArrayList<Member>();
		 * 
		 * String sql = "select * from project.member order by uname limit ?, ?";
		 * 
		 * memberList = jdbcTemplate.query(sql, new Object[] {startRow,count}, new
		 * MemberRowMapper());
		 * 
		 * return memberList;
		 */
		
		return jdbcTemplate.query("select * from project.member order by uidx limit ?, ?", new Object[] {startRow,count}, 
				new MemberRowMapper());
	}

	
	
	public List<Member> selectTotalList() throws SQLException {

		
		/*List<Member> memberList = new ArrayList<Member>();
		
		String sql = "select * from project.member order by uname";
		
		memberList = jdbcTemplate.query(sql, new MemberRowMapper());
		
		return memberList;*/
		
		return jdbcTemplate.query("select * from project.member order by uidx",new MemberRowMapper());
	}



	public int memberDelete(int uidx) {
		
		String sql = "delete from project.member where uidx=?";
				
		return jdbcTemplate.update(sql,uidx);
	}



	
	
	
	public Member selectByIdpw(String uid, String upw) {

		
		
		String sql = "select * from project.member where uid=? and upw=?";
		

		return jdbcTemplate.queryForObject(sql, new MemberRowMapper(),uid, upw);
	}



	public int selectById(String uid) {
		
		
			String sql = "select count(*) from project.member where uid=?";
			
		return jdbcTemplate.queryForObject(sql, Integer.class, uid);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
