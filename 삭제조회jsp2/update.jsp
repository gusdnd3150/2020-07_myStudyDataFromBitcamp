<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문정보업데이트</title>
</head>
<body>
	<form method="post" action="list.jsp">
		<table>
			<tr>
				<td>주문번호</td>
				<td><input type="text" name="order_num" value="<%=request.getParameter("order_num")%>" readonly></td>
			</tr>
			<tr>
				<td>주문항목번호</td>
				<td><input type="text" name="order_item" value="<%=request.getParameter("order_item")%>" readonly></td>
			</tr>
			<tr>
				<td>제품ID</td>
				<td><input type="text" name="prod_id" value="<%=request.getParameter("prod_id")%>"></td>
			</tr>
			<tr>
				<td>항목수량</td>
				<td><input type="text" name="quantity" value="<%=request.getParameter("quantity")%>"></td>
			</tr>
			<tr>
				<td>항목가격</td>
				<td><input type="text" name="item_price" value="<%=request.getParameter("item_price")%>"></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><input type="hidden" name="command" value="update"></td>
			</tr>
		</table>
	</form>

</body>
</html>