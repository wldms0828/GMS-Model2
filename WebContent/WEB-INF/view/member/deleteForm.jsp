<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>탈퇴화면</title>
</head>
<body>
	<form action="<%=ctx %>/member.do">
	ID : <br />
	<input type="text" name="USERID" /><br />
	PASS : <br />
	<input type="text" name="PASSWORD"  /><br />
	<input type="hidden" name="action" value = "deleteMember"  />
	<input type="hidden" name="page" value = "deleteResult" />
	<input type="submit" value = "전송" />
	</form>
</body>
</html>
