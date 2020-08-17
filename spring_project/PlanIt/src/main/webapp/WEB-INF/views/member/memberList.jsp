<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>
	<h1>회원 리스트</h1>
	<c:if test = "${not empty memberListView}">
		${memberListView.memberTotalCount}
	</c:if>
</body>
</html>