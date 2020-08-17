package com.aia.it.member.service;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.board.model.BoardList;
import com.aia.it.member.dao.MemberDaoInterface;
import com.aia.it.member.model.Member;
import com.aia.it.member.model.MemberListView;

@Service
public class MemberListService {
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	public MemberListView getview(
			HttpServletRequest request,
			HttpServletResponse response) {
		
		//view로 전달할 결과 데이터
		MemberListView memberListView = null;
		
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		
		//전체 게시물 개수 구하기
		int totalCnt = dao.totalCnt();
		
		//한페이지 당 노출할 게시물의 개수
		final int Member_CNT_PER_PAGE = 2;
		
		//현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		
		if (page != null) {
			try {
				currentPageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}
		
		//게시물의 첫번째 행의 index
		int startRow = 0;
		
		//한페이지에 누출할 리스트
		List<Member> memberList = null;
		
		if(totalCnt>0) {
			
			startRow=(currentPageNumber-1)*Member_CNT_PER_PAGE;
			
			System.out.println("startRow"+startRow);
			System.out.println("페이지"+page);
			
			memberList = dao.selectList(startRow,Member_CNT_PER_PAGE);
		}else {
			
			currentPageNumber = 0;
			memberList = Collections.emptyList();
			
		}
		
		memberListView = new MemberListView(totalCnt, currentPageNumber, memberList, Member_CNT_PER_PAGE, startRow);
		System.out.println("나는 멤버의 리스트뷰!"+memberListView);
		return memberListView;
	}

}
