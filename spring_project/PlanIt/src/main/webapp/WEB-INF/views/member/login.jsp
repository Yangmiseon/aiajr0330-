<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 중 입니다.</title>
</head>
<body>
<h1>로그인</h1>
	
	
	<c:if test="${result == 1}">

	<script>
	
	alert('로그인 되었습니다.');
	location.href='<c:url value='/board/boardList'/>';

	</script>
		
	
	
	</c:if>
	
	<c:if test="${result == 0}">
	<script>
	
	alert('아이디와 비밀번호를 확인해주세요.');
	location.href = '<c:url value="/login/login"/>';

	</script>
	
	</c:if>
</body>
</html>