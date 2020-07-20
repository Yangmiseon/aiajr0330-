<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">

</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div>
		<h1 class="subtitle">로그인</h1>
		
		<hr>
		
		<form action="loginReg.do" method="post">
		
			<input type="text" name="redirecUri" 
			
			value="<%= request.getHeader("referer")%>" style=" width : 50% ;" >			
			
			
			<table class="table">
				<tr>
					<td> ID </td>
					<td> <input type="text" name="uid"> </td>
				</tr>
				<tr>
					<td> PW </td>
					<td> <input type="password" name="upw"> </td>
				</tr>				
				<tr>
					<td></td>
					<td> <input type="checkbox" name="remember" value="r" > 아이디 기억하기  </td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="로그인"> </td>
				</tr>
			</table>
		
		</form>
		
		
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>