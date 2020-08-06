package com.app.op.member.dao;

import java.util.List;
import java.util.Map;

import com.app.op.member.model.Member;
import com.app.op.member.model.MemberXML;
import com.app.op.member.model.MemberXmlList;

public interface MemberDaoInterface {
	
	public int insertMember(Member member);
	public Member selectByIdpw(String uid, String upw);
	//회원 전체 리스트 반환
	public List<Member> selectTotalList();
	//전체 XML 회원 리스트
	public List<MemberXML> selectTotalListXml();
	//uidx 기반으로 거맥한 회원의 정보 반환
	public Member selectByIdx(int uidx);
	public int editMember(Member member);
	
	//전체 게시물의 개수 : 검색포함
	public int totalCount(Map search);
	//전체 게시물의 List<Member>로 변환
	public List<Member> selectList(Map search);
	public Member selectById(String uid);
}
