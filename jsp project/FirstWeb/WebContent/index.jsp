<%@ page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 <%String userName= (String)session.getAttribute("userName");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
    margin: auto;
}
*:hover{
    border: 1px solid black;

}
#contanar{
    margin-top: 10%;
    border: 1px solid red;
    width: 400px;
    height: 600px;
    background-color: pink;
    text-align: center;
}</style>
</head>
<body>
	<h1>안녕하세요</h1>
	<%
		//스크립트릿 영역:자바코드작성 앞으로는 사용하지 않는다.
		Date now = new Date();
	%>
	
		<!--표현식-->
		<%= now%>
		현재 접속이름:<%=userName %>
		<div id=contanar>
        <div id="maintitle">
            BITUUR
        </div>
        <div id="mainImg">

        </div>
      <%
    	session.setAttribute("userName", "king");
    %>
            <a href="session/sessionView01.jsp">start</a>
      

    </div>

</body>
</html>