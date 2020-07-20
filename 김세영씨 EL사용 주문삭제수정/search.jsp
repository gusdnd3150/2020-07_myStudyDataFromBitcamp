<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<script type="text/javascript">
	function add(){
		document.location="form.jsp";
	}
</script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div style="padding:20px">
		<form class="form-inline" action="main" method="post">
		  <div class="form-group">
		    <label for="cust_id"><strong>고객번호 &nbsp;</strong></label>
		    <input type="text" class="form-control" name="cust_id" id="cust_id" placeholder="Input"> &nbsp;
		  <input type="hidden" name="command" value="search">
		  <button type="submit" class="btn btn-info">조회</button><br><br> &nbsp;
		  <button type="button" class="btn btn-info" onClick='add()'>고객추가</button><br><br>
		  </div>
		</form>
	</div>
</body>
</html>