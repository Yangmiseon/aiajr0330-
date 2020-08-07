package com.aia.mm.dao;

import java.util.List;

import com.aia.mm.model.Member;

public interface MemberDao {

	//interface는  public이 생략이된형태.
	List<Member> selectList();
	
	int insertMember(Member member);
	
	Member selectByIdx(int uidx);
	
	int editMember(Member member);

	int deleteMember(int uidx);

}
