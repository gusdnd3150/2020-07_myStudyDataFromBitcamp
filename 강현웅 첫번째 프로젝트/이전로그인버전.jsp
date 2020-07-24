<%@ page language="java" contentType="text/html; charset=UTF-8"
     import=" java.util.*,morning.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
 request.setCharacterEncoding("UTF-8");
 MemberDAO memDAO=new MemberDAO();
 List<MemberVO> membersList =memDAO.listMembers();
%>
    
<html>
<head>
<meta charset="UTF-8">
    
</head>
<body>

<%   String id = request.getParameter("_id"); // 요청값 가져옴
	String pwd = request.getParameter("_pwd");
	
	
	for (int i=0; i<membersList.size();i++) {
		String member_id = membersList.get(i).getMemberId() ; //반드시 get값 스트링으로 전환
		String passward = membersList.get(i).getPassword();
		String name = membersList.get(i).getName();
		System.out.println(member_id+passward);
		
		if(member_id.equals(id)&&passward.equals(pwd)) {
			session.setAttribute("member", membersList.get(i));
			%><jsp:forward  page="login2.jsp" /><% 
					
		}else if (id.equals("")&&pwd.equals("")){
			%>
			<script>
			alert("아이디 비밀번호 입력해주세요");
			location.href="mainlogin.jsp";
			</script>
           <%
		}
		else{
			%>
			<script>
			alert("로그인 실패");
			location.href="mainlogin.jsp";
			</script>
           <%
		}
	}
%> 


</body>
</html>