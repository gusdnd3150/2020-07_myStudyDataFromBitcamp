<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored ="false" %>
    
    <%
    request.setCharacterEncoding("UTF-8"); //회원 정보를 표시하기 전에 한글 인코딩
    String id = request.getParameter("id");  //표현식으로 출력하기 위해 getparameter()메서드를
    String pwd = request.getParameter("pwd");   //이용해 회원 정보를 가져왔다.
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력</title>
</head>
<body>

   <table border = "1" align ="center" >
   <tr align = "center" bhcolor ="#99ccff">
   <td width="20%"><b> 아이디 </b></td>               //getParameter로 가져온 회원 정보를 표현식으로 출력
   <td width="20%"><b> 비밀번호 </b></td>
   <td width="20%"><b> 이름</b></td>
   <td width="20%"><b> 이메일</b></td>
   </tr>
   
   <tr align ="center">
   <td>${param.id} </td>
   <td>${param.pwd} </td>                             param객체를 이용해 겟파라미터 메서드를 이용하지 않고
   <td>${param.name} </td>                           바로 회원 정보를 출력
   <td>${param.email} </td>
   </tr>
   </table>

</body>
</html>