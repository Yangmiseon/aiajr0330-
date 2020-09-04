<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
<style>
	.check_ok {
		color : blue;
	}
	.check_not {
		color : red;
	}
	#idchk {
		display: none;
	}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


	<h1>회원가입</h1>
	
	<form id="regForm" method="post" enctype="multipart/form-data">
	<table class = "table">
		<tr>
			<td>아이디</td>
			<td> <input type="email" name="uid" id="uid" >
						 <span  id="checkmsg"></span>
						 <input type="checkbox" name="idchk" id="idchk">
					 </td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="upw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="uname" id="uname">
			 <span  id="checkmsg1"></span>
			<input type="checkbox" name="idchk" id="idchk"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="uphonenum"></td>
		</tr>
		<tr>
			<td>사진</td>
			<td><input type="file" name="uphoto"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="제출"></td>
		</tr>
	</table>
	</form>
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
<script>
	
	$(document).ready(function(){
		
		$('#regForm').submit(function(){
			
			if(!$('#idchk').prop('checked')){
				alert('아이디 중복 체크는 필수 항목 입니다');
				$('#uid').focus();
				return false;
			}
			
			
			
		});

		
		$('#uid').focusin(function(){
			
			$(this).val('');
			$('#idchk').prop('checked', false);
			
			$('#checkmsg').text('');
			
			$('#checkmsg').removeClass('check_not');
			$('#checkmsg').removeClass('check_ok');
		});
		
		$('#uid').focusout(function(){
			
			if($(this).val().length<1){
				$('#checkmsg').text("아이디 항목은 필수 항목입니다.");
				$('#checkmsg').addClass('check_not');
				return false;
			}
			
			// 비동기 통신
			$.ajax({
				url : 'idCheck',
				data : { uid : $(this).val()},
				success : function(data){
					if(data == 'Y'){
						$('#checkmsg').text("사용가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg').text("사용이 불가능한 아이디 입니다.");
						$('#checkmsg').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				}
			});
			
		});
		
		
	});
	
$(document).ready(function(){


		
		$('#uname').focusin(function(){
			
			$(this).val('');
			$('#idchk').prop('checked', false);
			
			$('#checkmsg1').text('');
			
			$('#checkmsg1').removeClass('check_not');
			$('#checkmsg1').removeClass('check_ok');
		});
		
		$('#uname').focusout(function(){
			
			if($(this).val().length<1){
				$('#checkmsg1').text("아이디 항목은 필수 항목입니다.");
				$('#checkmsg1').addClass('check_not');
				return false;
			}
			
			// 비동기 통신
			$.ajax({
				url : 'unameCheck',
				data : { uname : $(this).val()},
				success : function(data){
					if(data == 'Y'){
						$('#checkmsg1').text("사용가능한 아이디 입니다.");
						$('#checkmsg1').addClass('check_ok');
						$('#idchk').prop('checked', true);
					} else {
						$('#checkmsg1').text("사용이 불가능한 아이디 입니다.");
						$('#checkmsg1').addClass('check_not');
						$('#idchk').prop('checked', false);
					}
				}
			});
			
		});
		
		
	});
	
	
</script>