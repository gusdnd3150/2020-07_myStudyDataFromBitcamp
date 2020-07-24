<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html>
<html>
<head>
    

<meta charset="UTF-8">

<title> 로그인창 </title>
<style>
  .cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>

 <h1 class="cls1">로그인</h1>
 
 
<form  method="get" action="Login"  encType="UTF-8">
 <table align="center" >
   <tr>
     <td width="200"><p align="right" >아이디</td> 
     <td width="400"><input   type="text" name="_id" ></td>
   </tr>
 <tr>
     <td width="200"><p align="right" >비밀번호</td>
     <td width="400"><input   type="password" name="_pwd"  >
     </td>
   </tr>
   <tr align="center" >
    <td colspan="2" width="400"><input type="submit"  value="로그인" >
       <input type="reset" value="다시입력" > 
       <input type ="hidden" name ="command" value ="logins"></td>
   </tr>
 </table>
</form>

</html>