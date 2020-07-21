<%@page import="member.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<form id="editForm" action="memberEdit.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="idx" value="${member.idx}">
			<table>
				<tr>
					<td>아이디(email) </td>
					<td> <input type="email" name="uid" id="uid" value="${member.uid}" readonly  >아이디는 수정이 불가합니다.</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> <input type="password" name="upw" required> </td>
				</tr>
				<tr>
					<td>이름</td>
					<td> <input type="text" name="uname" value="${member.uname}" required> </td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo">
						<br>
						현재 파일 : ${member.uphoto}
						<input type="hidden" name="oldFile" value="${member.uphoto}" >
					 </td>
				</tr>
				<tr>
					<td></td>
					<td> 
						<input type="submit" name="회원가입">
						<input type="reset">
					</td>
				</tr>
			</table>
		</form>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>