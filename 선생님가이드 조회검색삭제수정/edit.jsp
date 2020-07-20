<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String order_num = request.getParameter("num");
	String order_item = request.getParameter("item");
	String prod_id = request.getParameter("prodId");
	String quantity = request.getParameter("quantity");
	String price = request.getParameter("price");
	String searchId = request.getParameter("searchId");
	String editId = request.getParameter("editId");
	String editProdId = request.getParameter("editProdId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보 수정</title>
</head>
<body>
	<form action="/WebStudy/searchOrder" method="get">
		주문번호 : <input type="text" name="order_num" size="10" value=<%=order_num %>><br>
		주문항목번호 : <input type="text" name="order_item" size="10" value=<%=order_item %>><br>
		제품ID : <input type="text" name="prod_id" size="10" value=<%=prod_id %>><br>
		항목수량 : <input type="text" name="quantity" size="10" value=<%=quantity %>><br>
		항목가격 : <input type="text" name="item_price" size="10" value=<%=price %>><br>
		<br>
		<input type="submit" value="수정">
		<input type="hidden" name="command" value="edit">
		<input type="hidden" name="searchId" value="<%=searchId %>">
		<input type="hidden" name="editId" value="<%=editId %>">
		<input type="hidden" name="editProdId" value="<%=editProdId %>">
	</form>
</body>
</html>