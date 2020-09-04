<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Modify Modal-->

	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

		<div class="modal-dialog" role="document">

			<div class="modal-content">

	    		<div class="modal-header">

	   				<h5 class="modal-title" id="exampleModalLabel">Kategorie Name</h5>

	      			

   					<button class="btn btn-secondary" type="button" data-dismiss="modal" aria-label="Close">

        				<i class="fa fa-fw fa-times"></i>

	        		</button>

	    		</div>

	       		

	    		<div class="modal-body">

	    			<input type="text" id="modifyName" name="modifyName" />

	    		</div>

	    		

	    		<div class="modal-footer">

	    			<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>

		       		<button class="btn btn-primary" type="button" id="btn_modify">Modify</button>

	    		</div>

			</div>

		</div>

	</div>





<script>

 $(document).on("click", "#modify", function(e) {

	    	$("#modifyModal").modal('show');



	    	$("#btn_modify").on("click", function(e) {

    			alert($(this).parent().siblings('span').text());

				var result = $("#modifyName").val();

				$("#modifyModal").modal('hide');

				$("#modifyName").val("");

			});

		});

</script>
</body>
</html>