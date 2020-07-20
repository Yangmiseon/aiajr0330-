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
		<h3>
		
		<c:if test="${resultCnt == 1}">
			<div>
				로그인완료
			</div>
			${member}
		</c:if>
		
		<c:if test="${resultCnt <= 0}">
		<script>			
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
		</script>
		</c:if>
		
		
		
		</h3>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>