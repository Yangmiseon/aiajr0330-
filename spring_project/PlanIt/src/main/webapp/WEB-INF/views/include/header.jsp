<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
<h1 id="header">PLANIT</h1>

<ul id="nav">
<li><a href="<c:url value="/board/boardList"/>">게시글 리스트</a></li>
<li><a href="<c:url value="/board/boardWrite"/>">게시글쓰기</a></li>
<li><a href="<c:url value="/member/memberReg"/>">회원가입</a></li>
<li><a href="<c:url value="/login/login"/>">로그인</a></li>
<li><a href="<c:url value="/member/memberList"/>">멤버리스트</a></li>
<li><a href="<c:url value="/daily/dailyReg"/>">/daily/dailyReg</a></li>
<li><a href="<c:url value="/planner/calendar"/>">/planner/calendar</a></li>
<li><a href="<c:url value="/planner/plannerReg"/>">/planner/plannerReg</a></li>
</ul>

</header>