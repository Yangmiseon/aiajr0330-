<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

</head>
<body>
<%@ include file="/include/header.jsp" %>

	<h3>회원 리스트</h3>
	<hr>
	
	<div>전체회원 ${MemberlistView.memberTotalCount} 명</div>
	
	<%-- <div class="msg_box">
	<c:if test="${not empty MemberlistView}">
	
	<c:forEach items="${MemberlistView.memberview}" var="member">
	
	<div class="msg_box">
		게시물 번호 : ${member.idx} <br>
		작성자 : ${member.uname} <br>
		메시지 : ${member.uphoto}<br>
	</div>	
	
	</c:forEach>
	
	</c:if>
		
		<a>수정|삭제</a>
	</div>	 --%>
	
	<%-- <c:if test="${not empty MemberlistView}">

		<div>전체회원 ${MemberlistView.memberTotalCount} 명</div>
		<hr>

		<table class="table">
			<tr>
				<th>no</th>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>사진</th>
				<th>관리</th>
			</tr>
			
		<c:if test="${not empty MemberlistView.memberList }">
		<c:forEach items="${MemberlistView.memberList}" var="member">
			<tr>
				<td>${member.idx}</td>
				<td>${member.uid}</td>
				<td>${member.uname}</td>
				<td>${member.upw}</td>
				<td><img alt="프사 " src="<c:url value="${member.uphoto}"/>">  </td>
				<td>
				<a href="memberEditForm.do?idx=${member.idx}">수정</a> 
				| 
				<a href="javascript:memberDel(${member.idx})">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
		</table>
		</c:if> --%>
	<%@ include file="/include/footer.jsp" %>
</body>
</html>