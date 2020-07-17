<%--
  Created by IntelliJ IDEA.
  User: nogari03
  Date: 2020/07/17
  Time: 10:04 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="updateForm" method="post" action="/order">
        주문번호 <input type="text" name="order_num" value="<%=session.getAttribute("order_num")%>" readonly><br>
        주문항목번호 <input type="text" name="order_item" value="<%=session.getAttribute("order_item")%>" readonly><br>
        제품ID <input type="text" name="prod_id" value="<%=session.getAttribute("prod_id")%>"><br>
        항목수량 <input type="text" name="quantity" value="<%=session.getAttribute("quantity")%>"><br>
        항목가격 <input type="text" name="item_price" value="<%=session.getAttribute("item_price")%>"><br>
        <input type="submit" value="수정">
        <input type="hidden" name="command" value="update">
    </form>
</body>
</html>
