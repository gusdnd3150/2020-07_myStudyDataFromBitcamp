<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script type="text/javascript">

	function fn_process() {
		$.ajax({
			type : "get",       //응답 데이터를 텍스트로 지정
			dataType : "text",    //응답 데이터를 텍스트로 지정   
			async:true,           //false인경우 동기식으로 처리
			url : "/pro15/ajaxTest1",               // 전송할 서블릿을 지정
			data : {param : "hello,jquery"},  //서버로 매개변수와 값을 설정
			success : function(data, textStatus) {  //전송과 응담이 성공했을 경우의 작업을 설정
				$('#message').append(data);  //서버 응답 메시지를 <div> 엘리먼트에 표시
			},
			error : function(data, textStatus) { //오류발생 시 내용
				alert('에러발생');
			},
			complete : function(data, textStatus) {  //완료 시 수행
				alert('작업을 완료하였습니다.');
			}
		});
	}
</script>
   

</head>
<body>

    <input type="button" value="전송하기" onclick="fn_process()" /> <br><br>
    <div id ="message"></div>

</body>
</html>