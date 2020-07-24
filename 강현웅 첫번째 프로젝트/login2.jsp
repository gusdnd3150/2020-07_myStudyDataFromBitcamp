<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="java.util.*,morning.*"
    %>
    
    
    
    <%
    request.setCharacterEncoding("utf-8");
    MemberVO membersList = (MemberVO)session.getAttribute("member");
    String name = membersList.getName();
    %>
    

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> 로그인 성공 페이지 </title>
</head>
<body>
          <h1  align="center"> 로그인을 축하드립니다. <%=name %> 님 </h1><br>
          
              <form action="Login" method ="get">
              <table align ="center">
              <input type= "submit" value="로그아웃" />
              <input type= "hidden" name ="command" value ="logout" >
              </table>
              </form>
              <br>
              
              <form action="modifyInformation.jsp" method ="get">
              <table align ="center">
              <input type= "submit" value="암호 변경" />
              </table>
              </form>
              <br>
              
              <form action="" method ="get">
              <table align ="center">
              <input type= "submit" value="방명록" />
              <input type= "hidden" name ="command" value ="" >
              </table>
              </form>
               <br>
              <form action="" method ="get">
              <table align ="center">
              <input type= "submit" value="게시판" />
              <input type= "hidden" name ="command" value ="" >
              </table>
              </form>
               <br>
              
</body>
</html>