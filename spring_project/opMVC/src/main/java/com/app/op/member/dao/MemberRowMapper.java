package com.app.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.op.member.model.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setUidx(rs.getInt("uidx"));
		member.setUid(rs.getNString("uid"));
		member.setUpw(rs.getNString("upw"));
		member.setUname(rs.getNString("uname"));
		member.setUphonenumber(rs.getNString("uphonenumber"));
		member.setUphoto(rs.getNString("uphoto"));
		return member;
	}

}
