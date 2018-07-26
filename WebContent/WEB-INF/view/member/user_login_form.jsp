<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">

<jsp:include page="../common/head.jsp" />

<body >
<div id = "user-login-layout">
<h1>로그인</h1>
<form id = "user_login_form" style = "border:1px solid black">
	ID :
	<input type="text" name="USERID"  />
	<br />
	PASSWORD:
	<input type="text" name="PASSWORD" />
	<br />
	<input type="hidden" name = "action" value = "login" />
	<input type="hidden" name ="page" value="mypage" />
	<input id="loginFormBtn" type="button" value ="전송"/>
</form>
</div>
	<script>	

	document.getElementById('loginFormBtn').addEventListener('click',function(){
		var member = new Member();
		var form = document.getElementById('user_login_form');	
		form.action = "${ctx}/member.do";
		form.method = "post";
		var USERID = form.USERID.value;
		var PASSWORD = form.PASSWORD.value;
		alert('입력한 ID : '+USERID);
		alert('입력한 pass : '+PASSWORD);
		member.setUserId(USERID);
		member.setPassword(PASSWORD);
		if(member.loginValidation()){
			form.submit();
		}

		
		
	});
	
	</script>
</body>
</html>