package com.aia.it.member.dao;

import java.util.List;

import com.aia.it.member.model.Member;

public interface MemberDaoInterface {
	
	//회원가입입력
	int insertMember(Member member);

	//회원가입이 되면 id를 검색하며 0,1로 반환해주어 회원 가입처리를 해줌
	int selectById(String uid);

	//가입한 회원의 전체 수
	int totalCnt();

	//startRow와 count를 이용한 한페이지에 보여질갯수
	List<Member> selectList(int startRow, int count);
	
	//가입한 회원의 전체 목록 리스트
	List<Member> selectTotalList();

	//로그인에 사용 id,pw
	Member selectByIdPw(String uid, String upw);

	int selectByUname(String uname);

}
