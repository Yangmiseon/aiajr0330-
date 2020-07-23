<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
홈 화면 출력됨<br />
<c:if test="${loginInfo != null }">
	${loginInfo } 로그인 중
</c:if>
<c:if test="${loginInfo == null }">
	<script>
		alert('로그인이 필요한 페이지 입니다.');		
		location.href= "<c:url value="/member/loginRegForm.do" />";
	</script>
</c:if>


</body>
</html>