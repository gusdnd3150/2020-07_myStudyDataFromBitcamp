<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 검색창</title>
  <script type="text/javascript">
	function frm_add() {
		var frmPro = document.frm;
		frmPro.method = "post";
		frmPro.action = "/WebStudy/member"; 
		frmPro.command.value = "addSearch";
		frmPro.submit();
	}
</script>
</head> 
<body>
   <form name="frm" method="post" action="/WebStudy/member">  
	   id:<input type="text" name="id"><br>
	   <input type ="submit" value="조회하기"><br>
	   <input type = "button" value = "제품추가" onclick = "frm_add()">
	   <input name = "command" type = "hidden" value = "search">
   </form>
</body>
</html>
