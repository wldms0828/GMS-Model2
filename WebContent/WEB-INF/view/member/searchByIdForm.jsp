<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctx = application.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
</head>
<body>
<form action="<%=ctx %>/member.do">

<input type="text" name = "USERID" />

<input type="hidden" name = "action" value = "searchByMemberId" />
<input type="hidden" name = "page" value = "searchByIdResult" />
<input type="submit" value = "전송" />
</form>
	
</body>
</html>