<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>null</title>
</head>
<body>
	<h1>보통의 오류들은 500으로 보내주면 된다. 나는 null이다.<br>
		타입이 우선된다.</h1>
	<a href="<%= request.getContextPath()%>/hello.jsp">홈으로 가기</a>
</body>
</html>