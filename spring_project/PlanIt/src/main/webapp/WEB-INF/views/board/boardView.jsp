<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뷰페이지</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div>
		${viewBoard}
		${viewBoard.bidx}
	</div>
	
      <h1 class="subtitle">제목 : ${viewBoard.btitle}</h1>
   
      <table class="table" border="1px">
            <tr>
               <th>no</th>
               <th>아이디</th>
               <th>게시글 제목</th>
               <th>게시글 내용</th>
               <th>사진</th>
               <th>사진</th>
            </tr>  
               <c:url value="${initParam['boardUploadPath']}" var="imagePath" />
             
                  <tr>
                     <td>${viewBoard.bidx}</td>
                     <td>${viewBoard.uidx}</td>
                     <td>${viewBoard.btitle}</td>
                     <td>${viewBoard.bmsg}</td>
                     <td><img alt="프사 " src="${imagePath}/${viewBoard.bphoto1}">
                     </td>
                     <td><img alt="프사 " src="${imagePath}/${viewBoard.bphoto2}">
                     </td>
                     
                  </tr>
          	 
         	  
         </table>
          <a href="boardEdit?bidx=${viewBoard.bidx}">수정</a> | 
         	  <a href="javascript:boardDel(${viewBoard.bidx})">삭제</a>

</body>
</html>
<script>
   function boardDel(bidx) {
      if (confirm('선택하신 게시물을 삭제하시겠습니까?')) {
         location.href = 'boardDelete?bidx=' + bidx;
      }

   }

   function boardList() {
      location.href = 'boardList';
   }
</script>
