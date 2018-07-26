<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  
<!--  userId, ssn, name, roll, teamId,password; -->
<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body id = "background">
	<form id="joinForm" action="${ctx}/member.do" >
	
	NAME : <br />
	<input type="text" name="NAME" /><br />
	SSN : <br />
	<input type="text" name="SSN" /><br />
	ID : <br />
	<input type="text" name="USERID" /><br />
	PASS : <br />
	<input type="text" name="PASSWORD" /><br />

	<input type="hidden" name = "action" value = "join">
	<input type="hidden" name = "page" value = "joinResult" />
	<input id="joinFormBtn" type="submit" value="전 송" />
	</form>
	<script>
		document.getElementById('joinFormBtn').addEventListener('click',function(){
			var form = document.getElementById('joinForm');
			form.action = "${ctx}/member.do";
			form.method = "post";
			var NAME = form.NAME.value;
			var SSN = form.SSN.value;
			var ID = form.ID.value;
			var PASS = form.PASS.value;
			form.submit();
		});
	</script>
</body>
</html>