<%@ page import="main.sec01.order.OrderVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<OrderVO> list = (List<OrderVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table, th, tr{
            border: solid 1px black;
        }
    </style>
</head>
<body>
<div>
    <form id="searchForm" method="post" action="/order">
    주문번호 <input type="text" name="order_num" >
    <input type="hidden" name="command" value="search">
    <button id="submit" align="right">조회</button>
    </form>
</div>
<hr>
<div>
    <table id = "table">
        <thead>
        <tr>
            <th>주문번호</th>
            <th>주문항목번호</th>
            <th>제품ID</th>
            <th>항목수량</th>
            <th>항목가격</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        </thead>
        <form name="rowForm" method="post">
        <%
            if(list != null){
                for(int i=0; i<list.size();i++){
        %>
        <tr>
            <td><%= list.get(i).getOrder_num() %></td>
            <td><%= list.get(i).getProd_id() %></td>
            <td><%= list.get(i).getOrder_item()%></td>
            <td><%= list.get(i).getQuantity() %></td>
            <td><%= list.get(i).getItem_price()%></td>

            <%
                String order_num = list.get(i).getOrder_num();
                String order_item = list.get(i).getOrder_item();
                String prod_id = list.get(i).getProd_id();
                String quantity = list.get(i).getQuantity();
                String item_price = list.get(i).getItem_price();

            %>
            <%
                session.setAttribute("order_num",order_num);
                session.setAttribute("order_item",order_item);
                session.setAttribute("prod_id",prod_id);
                session.setAttribute("quantity",quantity);
                session.setAttribute("item_price",item_price);
            %>

            <td>
                <input type="submit" value="수정" formaction="/orderUpdate.jsp">
            </td>
            <td>
                <input type="submit" value="삭제" formaction="/order">
                <input type="hidden" name="command" value="delete">
            </td>
        </tr>
        <%
            }
            }
        %>
        </form>
    </table>
</div>
</body>
</html>