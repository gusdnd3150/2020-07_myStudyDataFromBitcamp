<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    String id =(String)request.getAttribute("id");
    String pwd =(String)request.getAttribute("pwd");
    String name =(String)request.getAttribute("name");
    String email =(String)request.getAttribute("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>

    <table border="1" align ="center"></table>
    
    <tr align ="center" bgcolor =#99ccff">
    <td width ="20%"> 아이디  </td>
    <td width ="20%"> 비밀번호  </td>
    <td width ="20%"> 이름  </td>
    <td width ="20%"> 이메일  </td>
    </tr>
    
    
    <tr>
    <td> <%=id %></td>
    <td> <%=pwd %></td>
    <td> <%=name %></td>
    <td> <%=email %></td>
    </tr>
    
    <tr>
    <td>${id}</td>
    <td>${pwd}</td>
    <td>${name}</td>
    <td>${email}</td>
    </tr>
    </table>

</body>
</html>