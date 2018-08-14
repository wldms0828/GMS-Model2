<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="content-box">
	<div id="header">
		<jsp:include page="../common/titleBox.jsp" />
		<jsp:include page="../common/loginBox.jsp" />
		<jsp:include page="../common/menuBox.jsp" />
	</div>

	<!-- 		header end -->
	<div id="content">
		<form id="deleteForm">
<!-- 		id를 주어주면 객체
	getElementById메소드를 가진 객체 -> DOM객체
	name을 주면 속성을 가진 것 -->
			비밀번호 재입력 : <br />
			 <br />
			<input type="password" name="PASSWORD" id="PASSWORD"/>
<!-- 			id가 없기 때문에 객체가 아니다 -->
			<input type="button" id="deleteConfirmBtn" value="회원탈퇴하기"/>
<!-- 			<input type="hidden" name="page" value="deletemember" /> -->
<!-- 			<input type="hidden" name="page" value="mypage" /> 
				보여주기 위한것은 있으면 안된다 넘기기 위한것만 있으면 된다.		-->
			</form>
		
	</div>
	<!-- 		content end -->
	<div id="footer">
	<jsp:include page="../common/footerBox.jsp" />
	</div>	
</div>
	<script>
	document.getElementById('deleteConfirmBtn').addEventListener('click',function(){
		var form = document.getElementById('deleteForm');	
		var x = service.nullChecker([form.PASSWORD.value]);
		if(x.checker){
			if(form.PASSWORD.value==='${user.password}'){
				//form.PASSWORD.value에서 PASSWORD는 속성값
				form.action = "${ctx}/member.do";
				form.method = "post";
				var node = document.createElement('input');
				//document.createElement 는 document가 setter한거
				//input태그를 만든것
				//document.getElementById('deleteForm') 는
				//document가 getter
// 				node.innerHTML=
// 					'<input type = "hidden" name="action" value="deletemember"/>';
				//w3school의 오리지널 방법
				node.setAttribute('type','hidden');
				node.setAttribute('name','action');
				node.setAttribute('value','deletemember');
				//객체를 통한 방법
					form.appendChild(node);
					//node를 form의 자식으로 만들어 줘야 사용할 수 있다. 
				form.submit();
				alert('회원탈퇴성공');
			}else{
				alret('비밀번호가 다릅니다.');
			};
		}else{
			alert(x.text);}
		});
		
	</script>
	
	
</body>
</html>



<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>

<!-- <!doctype html> -->
<!-- <html lang="en"> -->
<%-- <jsp:include page="../common/head.jsp" /> --%>
<!-- <body> -->
<%-- 	<form action="${ctx}/member.do" > --%>
<!-- 	ID : <br /> -->
<!-- 	<input type="text" name="USERID" /><br /> -->
<!-- 	PASS : <br /> -->
<!-- 	<input type="text" name="PASSWORD"  /><br /> -->
<!-- 	<input type="hidden" name="action" value = "deleteMember"  /> -->
<!-- 	<input type="hidden" name="page" value = "deleteResult" /> -->
<!-- 	<input id="deleteFormBtn" type="button" value = "전송" /> -->
<!-- 	</form> -->
<!-- 	<script> -->
<!--  	document.getElementById('deleteFormBtn') -->
<!--  	.addEventListener('click',function(){ -->
<!--  		var form = document.getElementById('deleteForm'); -->
<%--  		form.action="${ctx}/member.do"; --%>
<!--  		form.method = "post"; -->
<!--  		form.submit(); -->
<!--  	}) -->
<!-- 	</script> -->
<!-- </body> -->
<!-- </html> -->
