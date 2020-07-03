<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="/error/error.jsp" %>
    <!--web.xml에서 에러설정을 해주고 그 외 에러는 특정페이지를 만들어 처리한다.
       web.xml에서 설정한 것보다 지금 이페이지처럼 특정 페이지가 먼저 인식된다.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>
</body>
</html>