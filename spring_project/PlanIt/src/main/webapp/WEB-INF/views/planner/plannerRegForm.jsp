<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>

<%   %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />
<style>
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	//<![CDATA[
	/** 아이템을 등록한다. */
	function submitItem() {
		if (!validateItem()) {
			return;
		}
		alert("등록");
	}
	/** 아이템 체크 */
	function validateItem() {
		var items = $("input[type='text'][name='item']");
		if (items.length == 0) {
			alert("작성된 아이템이 없습니다.");
			return false;
		}
		var flag = true;
		for (var i = 0; i < items.length; i++) {
			if ($(items.get(i)).val().trim() == "") {
				flag = false;
				alert("내용을 입력하지 않은 항목이 있습니다.");
				break;
			}
		}
		return flag;
	}
	/** UI 설정 */
	$(function() {
		$(".please").sortable({
			placeholder : "itemBoxHighlight",
			connectWith : ".please",
			start : function(event, ui) {
				ui.item.data('start_pos', ui.item.index());
			},
			stop : function(event, ui) {
				var spos = ui.item.data('start_pos');
				var epos = ui.item.index();
				reorder();
			}
		});
		//$("#itemBoxWrap").disableSelection();
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});
	/** 아이템 순서 조정 */
	function reorder() {
		$(".itemBox").each(function(i, box) {
			$(box).find(".itemNum").html(i + 1);
		});
	}
	/** 아이템 추가 */
	function createItem() {
		$(createBox())
				.appendTo("#itemBoxWrap")
				.hover(function() {
					$(this).css('backgroundColor', '#f9f9f5');
					$(this).find('.deleteBox').show();
				}, function() {
					$(this).css('background', 'none');
					$(this).find('.deleteBox').hide();
				})
				.append("<div class='deleteBox'>[삭제]</div>")
				.find(".deleteBox")
				.click(
						function() {
							var valueCheck = false;
							$(this).parent().find('input').each(
									function() {
										if ($(this).attr("name") != "type"
												&& $(this).val() != '') {
											valueCheck = true;
										}
									});
							if (valueCheck) {
								var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
							}
							if (!valueCheck || delCheck == true) {
								$(this).parent().remove();
								reorder();
							}
						});
		// 숫자를 다시 붙인다.
		reorder();
	}
	/** 아이템 추가 */
	function createItem2() {
		$(createBox())
				.appendTo("#itemBoxWrap2")
				.hover(function() {
					$(this).css('backgroundColor', '#f9f9f5');
					$(this).find('.deleteBox').show();
				}, function() {
					$(this).css('background', 'none');
					$(this).find('.deleteBox').hide();
				})
				.append("<div class='deleteBox'>[삭제]</div>")
				.find(".deleteBox")
				.click(
						function() {
							var valueCheck = false;
							$(this).parent().find('input').each(
									function() {
										if ($(this).attr("name") != "type"
												&& $(this).val() != '') {
											valueCheck = true;
										}
									});
							if (valueCheck) {
								var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
							}
							if (!valueCheck || delCheck == true) {
								$(this).parent().remove();
								reorder();
							}
						});
		// 숫자를 다시 붙인다.
		reorder();
	}
	/** 아이템 박스 작성 */
	// function createBox() {
	//     var contents = "<div class='date'> 날짜"
	//     contents +=         
	//                   "<div class='itemBox'>"
	//                  + "<div style='float:left;'>"
	//                  + "<span class='itemNum'></span> "
	//                  + "<input type='text' name='item' style='width:300px;'/>"
	//                  + "</div>"
	//                  + "</div>";
	//                  contents     += "</div>"
	//     return contents;
	// }
	/** 아이템 박스 작성 */
	function createBox() {
		var contents = "<li class='itemBox'>" + "<div style='float:left;'>"
				+ "<span class='itemNum'></span> "
				+ "<input type='text' name='item' style='width:300px;'/>"
				+ "</div>" + "</li>";
		return contents;
	}
	//]]>
</script>
<title>Insert title here</title>
</head>
<script>
	
</script>
<body>


						</div>
	uidx <input type="text" name="uidx" value="${loginInfo.uidx}"><br>
	<input type="text" name="pstartdate" value="${startdate}">/<input type="text" name="penddate" value="${enddate}"><br>
	제목<input type="text" name="ptitle" value="${ptitle}">
		<div id="sortable">
			<c:forEach items="${dateList}" var="list">
				<div class="please" name="dailytable">${list}
				
				
					<div class="itembox">
					<span class="zz">test</span>
						<div class="content"></div>
					</div>
				</div>
			</c:forEach>
		</div>
		
	
	<hr>
	
		<form action="dailyList" method="post">
	
		uidx <input type="text" name="uidx" value="${loginInfo.uidx}"><br>
	
		<input type="submit" value="리스트뽑기">
		<input type="text" value="${planner.pidx}">
	
		</form>
	
		<div>
		
		
		               <c:forEach items="${listView.dailyList}" var="daily">
                  <tr>
                     <td>${daily.ptitle}</td>
                   
                     <td>${daily.dloc}</td>
                     <td></td>
                     <td><a href="${daliy.didx}">${daliy.didx}</a></td>
                     <td></td>
                     
                  </tr>
               </c:forEach>
		
		
		
		
		
		
		</div>
	
	
	
	
	
	
</body>




</html>

<script type="text/javascript">


console.log($('.itembox').length);
		
		
		
		
		
		
		$('.zz').click(function () {
			
			$('.zz').
			
			var z = $(this).next();
			console.log(z);
			alert('test');
			var html='';
			html+='dloc		<input type="text" name="dloc">	<br>';
			html+='	dloclon		<input type="text" name="dloclon"><br>';
			html+='	dloclat		<input type="text" name="dloclat"><br>';
			html+='dmsg		<input type="text" name="dmsg"><br>';
			html+='	dphoto		<input type="file" name="dphoto"><br>';
			
				z.html(html);
			
			
		});
		
	






</script>