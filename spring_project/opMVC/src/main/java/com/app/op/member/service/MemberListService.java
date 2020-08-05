package com.app.op.member.service;

import java.security.cert.CollectionCertStoreParameters;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.op.jdbc.ConnectionProvider;
import com.app.op.member.dao.JdbcTemplateMemberDao;
import com.app.op.member.dao.MemberDao;
import com.app.op.member.dao.MemberDaoInterface;
import com.app.op.member.model.Member;
import com.app.op.member.model.MemberListView;

@Service
public class MemberListService {
	
	/*
	 * @Autowired MemberDao dao;
	 */
	
	private MemberDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	//JdbcTemplateMemberDao dao;
	
	
	public MemberListView getView(
			HttpServletRequest request, 
			HttpServletResponse response) throws SQLException {
		
		dao=sessionTemplate.getMapper(MemberDaoInterface.class);
		
		Map<String, Object> search = new HashMap<String, Object>();
		//search.put("searchType",searchType);//<if test="search.searchType">
		//search.put("keyword",keyword);
		
		//검색 데이터 : searchType, keyword
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");

		//검색데이터가 없으면 검색할 이유가 없음.
		if(searchType != null && searchType.isEmpty()) {
			search.put("searchType",searchType);
		}
		
		if(keyword != null && keyword.isEmpty()) {
			search.put("keyword",keyword);
		}
		
		

		// view 로 전달할 결과 데이터
		MemberListView listView = null;

		// 전체 게시물 개수 구하기
		int totalCnt = dao.totalCount(search);

		// 한 페이지 당 노출할 게시물의 개수
		final int MEMBER_CNT_PER_PAGE = 2;

		// 현재 페이지 번호
		int currentPageNumber = 1;
		String page = request.getParameter("page");
		if (page != null) {
			try {
				currentPageNumber = Integer.parseInt(page);
			} catch (NumberFormatException e) {
				System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생");
			}
		}

		// 게시물의 첫번째 행의 index
		int startRow = 0;

		// 한 페이지에 누출할 리스트
		List<Member> memberList = null;
		

		if (totalCnt > 0) {
			startRow = (currentPageNumber - 1) * MEMBER_CNT_PER_PAGE;

			System.out.println(startRow);
			
			// Map에 페이징 데이터 주가
			search.put("startRow", startRow);
			search.put("count", MEMBER_CNT_PER_PAGE);

			memberList = dao.selectList(search);
		} else {
			currentPageNumber = 0;
			memberList = Collections.emptyList();
		}

		listView = new MemberListView(totalCnt, currentPageNumber, memberList, MEMBER_CNT_PER_PAGE, startRow);

		System.out.println(listView);

		return listView;
	}
	

	/*
	 * public MemberListView getView( HttpServletRequest request,
	 * HttpServletResponse response) {
	 * 
	 * //view로 전달할 결과 데이터 MemberListView listView = null;
	 * 
	 * Connection conn=null;
	 * 
	 * try { conn= ConnectionProvider.getConnection();
	 * 
	 * //전체 게시물 개수 구하기 int totalCnt = dao.selectTotalCount();
	 * 
	 * //한 페이지 당 노출할 게시물의 개수 final int MEMBER_CNT_PER_PAGE = 2;
	 * 
	 * //현재 페이지 번호 int currentPageNumber = 1; String page =
	 * request.getParameter("page");
	 * 
	 * if(page != null) {
	 * 
	 * try {
	 * 
	 * currentPageNumber = Integer.parseInt(page);
	 * 
	 * }catch (NumberFormatException e) {
	 * System.out.println("숫자 타입의 문자열이 전달되지 않아 예외 발생"); } }
	 * 
	 * //게시물의 첫번째 행의 index int startRow = 0;
	 * 
	 * //한페이지에 누출할 리스트 List<Member> memberList = null;
	 * 
	 * if(totalCnt >0) {
	 * 
	 * startRow = (currentPageNumber-1)*MEMBER_CNT_PER_PAGE;
	 * 
	 * System.out.println(startRow);
	 * 
	 * memberList = dao.selectList(conn,startRow, MEMBER_CNT_PER_PAGE); }else {
	 * currentPageNumber = 0; memberList = Collections.emptyList(); }
	 * 
	 * listView = new MemberListView( totalCnt, currentPageNumber, memberList,
	 * MEMBER_CNT_PER_PAGE, startRow);
	 * 
	 * System.out.println(listView); } catch (SQLException e) {
	 * System.out.println("SQL 오류 발생"); e.printStackTrace(); } return listView; }
	 */

}
