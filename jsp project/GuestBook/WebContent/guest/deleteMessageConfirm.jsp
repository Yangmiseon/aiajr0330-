	<!-- 삭제를 원하면 비밀번호 눌러 비밀번호누르면 삭제되게할거임 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//var form = document.getElementById("delForm");
	
	function check(){
		
		if(confirm('삭제하시겠습니까?')){
			return true;
		}
		return false;
	};
</script>
</head>
<body>

	<h3>메시지를 삭제하고자 하시면 비밀번호를 입력해 주세요.</h3>
	<!-- 비밀번호와 게시물번호를 같이 보내줘야함 -->
	<form id="delForm" action="deleteMessage.jsp" 
		  onsubmit="return check();" method="post">
		  
		비밀번호 <input type="password" name="pw">
		<!-- 사용자에게 보여줄필요없고 서버엔보내야하니까 히든! -->
		<input type="hidden" name="mid" value="${param.mid}">
		<input type="submit" value="삭제하기">	
		
	</form>
</body>
</html>