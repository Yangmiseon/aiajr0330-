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

	${listView.memberList}
	
	<div>
			<c:if test ="${sessionID != null}">
				${listView.memberList}
			</c:if>
			<c:if test ="${sessionID == null}">
				ㅇ람알머이러미아러ㅣㅁㅇㄹ
			</c:if>
			
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>