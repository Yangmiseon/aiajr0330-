<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<h1 class="subtitle">회원 수정</h1>
		<hr>
		<h3>
		
		<c:if test="${result > 0}">
			<script>
				alert('회원수정 완료');
				location.href='<c:url value="/member/memberList.do"/>';
			</script>
		</c:if>
		
		<c:if test="${result < 1}">
			<script>
				alert('회원수정 실패');
				location.href='<c:url value="/member/memberList.do"/>';
			</script>
		</c:if>
		
		
		
		</h3>
	</div>
</body>
</html>