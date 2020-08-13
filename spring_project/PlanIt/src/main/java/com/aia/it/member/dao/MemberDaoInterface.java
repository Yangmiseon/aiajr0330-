package com.aia.it.member.dao;

import com.aia.it.member.model.Member;

public interface MemberDaoInterface {
	
	int insertMember(Member member);

	int selectById(String uid);

}
