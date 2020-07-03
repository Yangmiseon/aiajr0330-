<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 	request.setCharacterEncoding("utf-8");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>
</head>
<body>
	<h1>회원가입 처리 페이지</h1>
	<br>
	<table>
		<tr>
			<td>이름</td>
			<td><%= request.getParameter("uid") %></td>
		</tr>
		
		<tr>
			<td>학번</td>
			<td><%= request.getParameter("upw") %></td>
		</tr>
		
		<tr>
			<td>학과</td>
			<td><%= request.getParameter("uname") %></td>
		</tr>
		
		<tr>
			<td>사진</td>
			<td><%= request.getParameter("uphoto") %></td>
		</tr>
	</table>
</body>
</html>