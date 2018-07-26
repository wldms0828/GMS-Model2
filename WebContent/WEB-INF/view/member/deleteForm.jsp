<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
	<form action="${ctx}/member.do" >
	ID : <br />
	<input type="text" name="USERID" /><br />
	PASS : <br />
	<input type="text" name="PASSWORD"  /><br />
	<input type="hidden" name="action" value = "deleteMember"  />
	<input type="hidden" name="page" value = "deleteResult" />
	<input id="deleteFormBtn" type="submit" value = "전송" />
	</form>
	<script>
	document.getElementById('deleteFormBtn').addEventListener('click',function(){
		var form = document.getElementById('deleteForm');
		form.action="${ctx}/member.do";
		form.method = "post";
		var ID = form.USERID.value;
		var PASS = form.PASSWORD.value;
		form.submit();
	})
	</script>
</body>
</html>
