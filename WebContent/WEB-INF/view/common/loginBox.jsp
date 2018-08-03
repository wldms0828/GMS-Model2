<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="login-box">
	<a id="moveLoginForm" >LOGIN</a>
	&nbsp;&nbsp;&nbsp; 
	<a id="moveJoinForm" >JOIN</a><br />
	
</div>

<!-- <script>
	var common = new common();
	common.move();
</script> -->
<script>
	// var moveLoginForm = document.getElementById('moveLoginForm');
	document.getElementById('moveLoginForm').addEventListener('click',function(){ //콜백함수
		alert('로그인 클릭 이벤트 체크!'+'${ctx}');
		router.move({ctx : '${ctx}',
			domain : 'member', 
			action : 'move',
			page : 'user_login_form'});
		//배열을 사용하지 않고 JSON을 사용
		/* var x = ['${ctx}','member','move','user_login_form'] */
	});
	
	document.getElementById('moveJoinForm').addEventListener('click',function(){
		alert('조인 클릭 이벤트 체크');
		router.move({ctx : '${ctx}',
			domain : 'member', 
			action : 'move',
			page : 'joinForm'});
	});
	document.getElementById('movedeleteForm').addEventListener('click',function(){
		router.move({ctx : '${ctx}',
			domain : 'member', 
			action : 'move',
			page : 'deleteForm'});
	})
		
</script>