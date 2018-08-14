<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content-box">
<jsp:include page="../common/head.jsp" />

<div id = "user-login-layout">
<h1>로그인</h1>
<form id = "user_login_form" name="user_login_form" style = "border:1px solid black">
	ID :<br />
	<input type="text" name="USERID"  />
	<br />
	PASSWORD:	<br />
	<input type="text" name="PASSWORD" />
	<br />
<!-- 	<input type="hidden" name = "action" value = "login" /> -->
	<input id="loginFormBtn" type="button" value ="전송"/>
</form>
</div>
</div>	
	<script>	

	document.getElementById('loginFormBtn').addEventListener('click',function(){
		
		var x = service.nullChecker([document.user_login_form.USERID.value
			,document.user_login_form.PASSWORD.value]);
		if(x.checker){
			var form = document.getElementById('user_login_form');	
			form.action = "${ctx}/member.do";
			form.method = "post";
			
			var node = document.createElement('input');
			node.innerHTML=
				'<input type = "hidden" name="action" value="login"/>';
				form.appendChild(node);
				
			var node1 = document.createElement('input');
			node.innerHTML=
				'<input type = "hidden" name="page" value="retrieve">';
				form.appendChild(node1);
			form.submit();
		}else{
			alert(x.text);
		}	
		
	
		
	});

	</script>
</body>
</html>