<%@page import="guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pw = request.getParameter("pw");
	int idx =Integer.parseInt(request.getParameter("idx")); 

	
	DeleteMessageService service = DeleteMessageService.getInstance();
	int resultCnt = service.deleteMessage(idx, pw);
	request.setAttribute("resultCode", resultCnt);
			
%>

${resultCode}
<jsp:forward page="deleteMessage_view.jsp"/>