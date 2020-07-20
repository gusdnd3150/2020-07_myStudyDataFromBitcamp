<%@ page language="java"   contentType="text/html; charset=UTF-8"
     import="java.util.*,sec01.ex01.*" 
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
%>    

<%
   String   id=request.getParameter("id");
   String  pwd = request.getParameter("pwd");            입력된 회원정보를 가져옴
   String  name = request.getParameter("name");
   String  email = request.getParameter("email");
 
  
   MemberBean  m =  new MemberBean(id, pwd, name, email);        맴버객체 생성 후 속성을 addmember메소드의 파라미터로 넣음
   MemberDAO  memberDAO=new MemberDAO();
   memberDAO.addMember(m); 
   List membersList = memberDAO.listMembers();	            전체 회원을 조회
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 목록창</title>
</head>
<body>
  <table align="center"  width="100%">
	 <tr align="center" bgcolor="#99ccff">
	      <td width="7%" >아이디</td>
	      <td width="7%">비밀번호</td>
	      <td width="5%" >이름</td>
	      <td width="11%" >이메일</td>
	      <td width="5%" >가입일</td>
	   </tr>
	<%
	   if(membersList.size()==0){
	%>
	  <tr>
	      <td colspan="5">
	        <p align="center"><b><span style="font-size:9pt;">
	                      등록된 회원이  없습니다.</span></b></p>
	      </td>
	  </tr>
	<%
	}else{
	   for( int i = 0; i < membersList.size(); i++ ) {              반복문 사용하여 list에 저장된 Bean객체를 하나씩 불러옴
	      MemberBean bean = (MemberBean) membersList.get(i);          가져온 정보를 get으로 받는다
	%>
	   <tr align="center">
	       <td><%=bean.getId() %></td>
	       <td><%=bean.getPwd() %></td>
	       <td><%=bean.getName() %></td>
	       <td><%=bean.getEmail() %></td>
	       <td><%=bean.getJoinDate() %></td>
	   </tr>
	<%
	      } // end for
	
	   } // end if
	%>
	   <tr height="1" bgcolor="#99ccff">
	      <td colspan="5"></td>
	   </tr>
	</table>
</body>
</html>
