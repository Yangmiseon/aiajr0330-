<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

<style>

</style>
</head>
<body>

	<%@ include file="/include/header.jsp" %>

	<div>
		<h1 class="subtitle">회원가입</h1>
		
		<hr>
		
		<h3>
			<!--성공의 조건  -->
			<c:if test="${result gt 0 && member ne null}">
			<div>회원가입 완료</div>
			${member}
			</c:if>
			
			<!--실패!  -->
			<c:if test="${not(result gt 0 && member ne null)}">
			회원가입 실.패.
			</c:if>
		</h3>
	</div>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>








