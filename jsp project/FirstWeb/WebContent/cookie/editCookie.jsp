<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="util.CookieBox" %>
    
    <%
    	Cookie[] cookies = request.getCookies();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 정보 수정</h1>
	<%
/* 	
	Cookie cookie = new Cookie("uid", "scott");
	cookie.setPath("/web/");
	response.addCookie(cookie); */
	response.addCookie(CookieBox.createCookie("uid", "hot", "/web", -1));

	%>
	
	<a href="viewCookie.jsp">쿠키값 확인하기</a>
</body>
</html>