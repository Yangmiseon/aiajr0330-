<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String userName = (String)session.getAttribute("userName");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session의 속성으로 저장한 데이터23456 <br>
	username:<%=userName %><br>
	<a href="../index.jsp">다른페이지</a></h1>
</body>
</html>