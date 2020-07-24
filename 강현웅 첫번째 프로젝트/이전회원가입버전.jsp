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

<%   String joinid = request.getParameter("joinid"); // 요청값 가져옴
     String joinpwd= request.getParameter("joinpwd");
     String joinrepwd= request.getParameter("joinrepwd");
	
	
	for (int i=0; i<membersList.size();i++) {
		String member_id = membersList.get(i).getMemberId() ; //반드시 get값 스트링으로 전환
		System.out.println(member_id);
		
		if(member_id.equals(joinid)) {
			%>
			<script>
			alert("아이디가 중복됩니다.");
			location.href="joinIDcheck.jsp";
			</script>
           <%
			
					
		}else if (!joinpwd.equals(joinrepwd)){
			%>
			<script>
			alert("비밀번호가 일치하지 않습니다.");
			location.href="joinIDcheck.jsp";
			</script>
           <%
		}
		else if (!member_id.equals(joinid)){
			
			%>
			<script>
			alert("회원가입이 완료 되었습니다.");
			location.href="joinIDcheck.jsp";
			</script>
           <%
		}
	}
%> 


</body>
</html>