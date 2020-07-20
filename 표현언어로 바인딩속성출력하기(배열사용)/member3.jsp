<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  
      <table border="1" align ="center"></table>
    
    <tr align ="center" bgcolor =#99ccff">
    <td>${membersList[1].id}</td>
    <td>${membersList[1].pwd}</td>
    <td>${membersList[1].name}</td>
    <td>${membersList[1].email}</td>
    </tr>
    
    
   
    
    <tr align ="center" bgcolor =#99ccff">
    <td>${membersList[0].id}</td>
    <td>${membersList[0].pwd}</td>
    <td>${membersList[0].name}</td>
    <td>${membersList[0].email}</td>
    </tr>
    </table>

</body>
</html>