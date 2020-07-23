<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<ul id="nav">
		
		<li><a href="${pageContext.request.contextPath}/member/memberRegForm.do">회원가입</a></li>
		
		<li><a href="<c:url value="/member/memberList.do"/>">회원 리스트</a></li>
		
		<c:if test="${!empty loginInfo}">
		<li><a href="<c:url value="/member/logout.do"/>">로그아웃</a></li>
		</c:if>
		
		<c:if test="${empty loginInfo}">
		<li><a href="<c:url value="/member/loginRegForm.do"/>">로그인</a></li>
		</c:if>
		
		<li><a href="<c:url value="/member/mypage.do"/>">마이페이지</a></li>
		<li><a href="<c:url value="/board/boardList.do"/>">방명록(회원제)</a></li>
	</ul>
</body>
</html>