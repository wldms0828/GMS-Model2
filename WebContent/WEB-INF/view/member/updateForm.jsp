<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>비밀번호 변경</title>
</head>
<body>

	<form action="<%=ctx %>/member.do">
		ID : <br /> <input type="text" name="USERID" /><br /> 
		PASS : <br />
		<input type="text" name="PASSWORD" /><br /> 
		NEWPASS : <br /> 
		<input type="text" name="NEWPASSWORD" /><br /> 
		<input type="hidden" name="action" value="updateMember" />
		<input type="hidden" name="page" value="updateResult" />
		<input type="submit" value="전 송" />


	</form>
</body>
</html>

