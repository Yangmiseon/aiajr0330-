package com.app.op.member.dao;

import java.util.List;
import java.util.Map;

import com.app.op.member.model.Member;

public interface MemberDaoInterface {
	
	public int insertMember(Member member);
	public Member selectByIdpw(String uid, String upw);
	public Member selectByIdx(int uidx);
	public int editMember(Member member);
	
	//전체 게시물의 개수 : 검색포함
	public int totalCount(Map search);
	//전체 게시물의 List<Member>로 변환
	public List<Member> selectList(Map search);
	public Member selectById(String uid);
}
