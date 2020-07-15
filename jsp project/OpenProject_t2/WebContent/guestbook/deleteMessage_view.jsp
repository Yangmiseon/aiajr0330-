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
<c:if test="${resultCode  == 1}">
	<h1>삭제</h1>
	
	</c:if>
	
	<c:if test="${resultCode  == -1}">
	<h1>없어</h1>
	
	</c:if>
	
	<c:if test="${resultCode  == -2}">
	<h1>일지안함</h1>
	
	</c:if>
	
	<a href="list.jsp">리스트 보기</a>
	

	<%@ include file="/include/footer.jsp" %>
</body>
</html>