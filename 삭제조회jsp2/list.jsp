<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="web_0717.*" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	OrderDAO dao = new OrderDAO();
	String _orderNum = request.getParameter("order_num");
	String _command = request.getParameter("command");
	if("delete".equals(_command)) {
		String _orderItem = request.getParameter("order_item");
		dao.delOrder(_orderNum, _orderItem);
		//response.sendRedirect("list.jsp");
		_orderNum = "";
	} else if("update".equals(_command)) {
		String order_num = request.getParameter("order_num");
		String order_item = request.getParameter("order_item");
		String prod_id = request.getParameter("prod_id");
		String quantity = request.getParameter("quantity");
		String item_price = request.getParameter("item_price");
		dao.update(order_num, order_item, prod_id, quantity, item_price);
		_orderNum = "";
	}
	List orderList = dao.listOrders(_orderNum);
	//HttpSession sessoin = request.getSession();
	%>
	<table border=1 width=800 align=center >
		<tr bgcolor="lightgreen">
			<th>주문번호</th>
			<th>주문항목번호</th>
			<th>제품ID</th>
			<th>항목수량</th>
			<th>항목가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<%
			for (int i = 0; i < orderList.size(); i++) {
			OrderVO vo = (OrderVO) orderList.get(i);
			String order_num = vo.getOrder_num();
			String order_item = vo.getOrder_item();
			String prod_id = vo.getProd_id();
			String quantity = vo.getQuantity();
			String item_price = vo.getItem_price();
		%>
		<%!
		void delete(String order_num, String order_item) {
			OrderDAO dao = new OrderDAO();
			dao.delOrder(order_num, order_item);
		}
		%>
		<tr align="center">
			<td><%=order_num %></td>
			<td><%=order_item %></td>
			<td><%=prod_id %></td>
			<td><%=quantity %></td>
			<td><%=item_price %></td>
			<td><a href="update.jsp?order_num=<%=order_num%>
					&order_item=<%=order_item%>
					&prod_id=<%=prod_id%>
					&quantity=<%=quantity%>
					&item_price=<%=item_price%>">수정</a></td>
			<td><a href='list.jsp?command=delete&order_num=<%=order_num %>&order_item=<%=order_item%>'>삭제</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>