<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${loginCnt>0}">
<script>
	location.href='<c:url value="/member/mypage.do"/>';
	</script>
</c:if>

<c:url value="/member/mypage.do"/>
