<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">

<jsp:include page="../common/head.jsp" />

<body >
<div id = "user-login-layout">
<h1>로그인</h1>
<form id = "user_login_form" name="user_login_form" style = "border:1px solid black">
	ID :
	<input type="text" name="USERID"  />
	<br />
	PASSWORD:
	<input type="text" name="PASSWORD" />
	<br />
	<input type="hidden" name = "action" value = "login" />
	<input id="loginFormBtn" type="button" value ="전송"/>
</form>
</div>
	<script>	

	document.getElementById('loginFormBtn').addEventListener('click',function(){
		//var member = new Member();
		//var form = document.getElementById('user_login_form');	
		var x = service.nullChecker([document.user_login_form.USERID.value
			,document.user_login_form.PASSWORD.value]);
		if(x.checker){
			var form = document.getElementById('user_login_form');	
			form.action = "${ctx}/member.do";
			form.method = "post";
			form.submit();
		}else{
			alert(x.text);
		}	
		
		//var USERID = form.USERID.value;
		//var PASSWORD = form.PASSWORD.value;
		//member.setUserId(USERID);
		//member.setPassword(PASSWORD);
		

		
		
	});
	
	</script>
</body>
</html>