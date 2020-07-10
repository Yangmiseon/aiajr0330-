<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${result>0}">
	
		이름 : ${report.sname}<br>
		학번 : ${report.sno}<br>
		<img  src="<c:url value="${report.report}"/>">
		<!--파일경로를 컨텍스트경로제외하고 들어옴.  -->
		
	</c:if>

	<c:if test="${result eq 0}">
	
		<h1>저장되지 않았습니다.</h1>
		
	</c:if>

</body>
</html>