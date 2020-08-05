<%@page import="com.app.op.member.model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원리스트</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">


<style>
	td>img{
		width :50px;
		height : 50px;
	}
	
	div.searchBox{
		border: 1px solid #DDD;
		padding: 20px;
		width: 75%;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div>
	<h1 class="subtitle">마이 페이지</h1>
			
		<div>${loginInfo} 회원님의 정보입니다.</div>
		<hr>

	 	<table class="table">
			<tr>
				<th>아이디</th>
				 <th>비밀번호</th>
				<!--<th>이름</th>
				<th>전화번호</th>
				<th>사진</th>
				<th></th> -->
			</tr>
			
		<%--<c:url value="${initParam['memberUploadPath']}" var="imagePath"/>--%>
			<tr>
				<td>${member.uid}</td>
				 <td>${member.upw}</td>
				<%--<td>${loginInfo.uname}</td>
				<td>${loginInfo.uphonenumber}</td>
				<td><img alt="프사 " src="${imagePath}/${loginInfo.uphoto}">  </td>
				<td>
				<a href="memberEdit?uidx=${loginInfo.uidx}">수정</a> 
				| 
				<a href="javascript:memberDel(${loginInfo.uidx})">삭제</a></td> --%>
			</tr>
		</table> 
	
<%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>
