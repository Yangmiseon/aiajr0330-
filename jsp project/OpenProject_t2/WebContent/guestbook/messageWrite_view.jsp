<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<c:if test="${writeResult > 0}">
	
	<h1>글이 정상적으로 작성되었습니다.</h1>
	
	</c:if>
	
	<c:if test="${writeResult == 0}">
	<h1>글쓰기 실패!</h1>
	</c:if>
	
	<a href="list.jsp">목록보기</a>

	<%@ include file="/include/footer.jsp" %>
</body>
</html>