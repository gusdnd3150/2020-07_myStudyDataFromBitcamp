<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="customer.* "%>
    
<jsp:useBean id="vo" class="customer.CustomerVO" scope="request"></jsp:useBean>
<jsp:setProperty name="vo" property="*"/>

<%
	String command, btnName;
	if(vo.getCust_id()==null || vo.getCust_id().equals("null")){
		vo = new CustomerVO("","","","","","","","","");
		command = "add";
		btnName ="추가";
	}else{
		command = "editCompl";
		btnName ="수정";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style type="text/css">
	div {padding: 30px}
</style>
</head>
<body>
	<div>
		<form action="main" method="post"><table>
		<tr><td><label for="order_num">고객번호</label></td><td><input type="text" name="cust_id" value=" ${ vo.getCust_id()} "></td></tr>
		<tr><td><label for="order_item">고객이름</label></td><td><input type="text" name="cust_name" value="${ vo.getCust_name() }"></td></tr>
		<tr><td><label for="prod_id">고객주소</label></td><td><input type="text" name="cust_address" value="${ vo.getCust_address() }"></td></tr>
		<tr><td><label for="quantity">고객도시</label></td><td><input type="text" name="cust_city" value="${ vo.getCust_city() }"></td>	</tr>
		<tr><td><label for="item_price">고객주</label></td>	<td><input type="text" name="cust_state" value="${ vo.getCust_state() }"></td></tr>
		<tr><td><label for="item_price">고객우편번호</label></td>	<td><input type="text" name="cust_zip" value="${ vo.getCust_zip() }"></td></tr>
		<tr><td><label for="item_price">고객국가</label></td>	<td><input type="text" name="cust_country" value="${ vo.getCust_country() }"></td></tr>
		<tr><td><label for="item_price">고객담당자</label></td>	<td><input type="text" name="cust_contact" value="${ vo.getCust_contact() }"></td></tr>
		<tr><td><label for="item_price">고객메일주소</label></td>	<td><input type="text" name="cust_email" value="${ vo.getCust_email() }"></td></tr>
		</table><br><input class="btn btn_info" type="submit" value="<%= btnName %>">
		<input type="hidden" name="command" value="<%= command %>">
		<input type="hidden" name="ori_id" value="<%= vo.getCust_id() %>">
		<input type="hidden" name="ori_name" value="<%= vo.getCust_name() %>">
		
		</form>
	</div>
</body>
</html>