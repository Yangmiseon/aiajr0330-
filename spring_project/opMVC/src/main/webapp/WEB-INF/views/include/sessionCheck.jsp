<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${loginInfo == null }">
	<script>
		alert('로그인이 필요한 페이지 입니다.');		
		location.href= '<c:url value="/login/login" />';
	</script>
</c:if>
</body>
</html>