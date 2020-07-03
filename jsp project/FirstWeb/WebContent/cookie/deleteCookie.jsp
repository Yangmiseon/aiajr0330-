<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="util.CookieBox" %>
    
    <%
    	/* Cookie cookie = new Cookie("uname", "");
    	cookie.setMaxAge(0);
    	response.addCookie(cookie); */
    	response.addCookie(CookieBox.createCookie
    			("uname", "", "/web/cookie", 0));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키 삭제한다.</h1>
	
	<a href="viewCookie.jsp">쿠키 확인</a>
</body>
</html>