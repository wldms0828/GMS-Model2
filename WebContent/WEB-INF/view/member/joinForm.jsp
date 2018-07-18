<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String ctx = application.getContextPath();
%>
  
<!--  userId, ssn, name, roll, teamId,password; -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>회원가입화면</title>
</head>
<body id = "background">
	<form action="<%=ctx%>/member.do">
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
	<input type="submit" value="전 송" />
	</form>
	
</body>
</html>