<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="study09.*"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
text-align: center;
}
</style>
  <meta charset="UTF-8">
<title>회원 정보 출력창</title> 
</head>
<body>
<h1>회원 정보 출력</h1>
<%
   request.setCharacterEncoding( "utf-8" );

   List membersList = (List)request.getAttribute("membersList");
%>
 <table border='1' width='800' align='center'>
   <tr align='center' bgcolor='#FFFF66'> 
     <td>아이디</td>
     <td>비밀번호</td>
     <td>이름</td>
     <td >이메일</td>
     <td>수정</td>
</tr>
<%	
   for (int i=0; i < membersList.size(); i++){
      MemberVO vo=(MemberVO) membersList.get(i);
      String id=vo.getId();
      String pwd=vo.getPwd();
      String name=vo.getName();
      String email=vo.getEmail();
%>
     <tr align=center>
       <td><%= id %></td>
       <td><%= pwd %></td>
       <td><%= name %></td>
       <td><%= email %></td>
       <td><a href='/WebStudy/member?command=modSearch&mod_id=<%= id %>'> 수정 </a></td>
     </tr>
   
<%		
   }
%>	
</table>
</body>
</html>
