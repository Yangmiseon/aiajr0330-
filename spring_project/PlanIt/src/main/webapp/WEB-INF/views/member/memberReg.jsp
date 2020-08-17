<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입처리</title>
</head>
<body>
<h1>회원가입처리</h1>
	
	
	<c:if test="${result gt 0}">

	<script>
	
	alert('회원가입 완료');
	location.href = '<c:url value="/index.do"/>';
	/* location.href = '<c:url value="/login/login"/>'; */

	</script>
		
	
	
	</c:if>
	
	<c:if test="${result lt 1}">
	<script>
	
	alert('회원가입 실패');
	location.href = '<c:url value="/index.do"/>';

	</script>
	
	</c:if>
</body>
</html>