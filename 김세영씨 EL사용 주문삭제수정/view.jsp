<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="customer.*" %>

<jsp:useBean id="list" type="java.util.List<CustomerVO>" class="java.util.ArrayList" scope="request"></jsp:useBean>

<%
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>항목조회</title>
<style>
	div { margin: 0 auto}
	th, td {text-align: center}
</style>
</head>
<body>
	<div>
		<table class="table">
			<thead>
				<tr align='center'>
					<th>고객번호</th><th>고객이름</th>
					<th>고객주소</th><th>고객도시</th><th>고객주</th><th>고객우편번호</th>
					<th>고객국가</th><th>고객담당자</th><th>고객메일주소</th>
					<th>수정</th>
				</tr>
			</thead>
		<tbody>
		<%
			for(CustomerVO vo: list) {
				System.out.println(vo.getCust_id() + "** ");
		%>
				<tr><td> <%= vo.getCust_id() %></td>
				<td> <%= vo.getCust_name() %></td>
				<td> <%= vo.getCust_address() %></td>
				<td> <%= vo.getCust_city() %></td>
				<td> <%= vo.getCust_state() %></td>
				<td> <%= vo.getCust_zip() %></td>
				<td> <%= vo.getCust_country() %></td>
				<td> <%= vo.getCust_contact() %></td>
				<td> <%= vo.getCust_email() %></td>
				<td><a href='main?cust_id=<%= vo.getCust_id().trim() %>&cust_name=<%= vo.getCust_name().trim() %>&command=edit'>수정</a></td>
		<%
		}
		%>
			</tbody>
		</table>
	</div>
</body>
</html>