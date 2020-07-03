<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 처리하고 인덱스로 보낼거임: session객체 소멸
	session.invalidate();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 페이지</title>

<style>

</style>
</head>
<body>

	<h1>로그아웃되었습니다.</h1>
	<a href="mypage.jsp">MyPage</a>
	<a href="logout.jsp">logout</a>
	
</body>
</html>