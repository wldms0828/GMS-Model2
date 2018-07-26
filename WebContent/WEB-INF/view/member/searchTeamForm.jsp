<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>팀명으로 검색하기</title>
</head>
	<body>
		<form action="${ctx}/member.do" >
		TEAMID : <br />
		<input type="text" name = "TEAMID" /><br />
		<input type="hidden" name = "action" value = "searchByMemberTeam" /> -->
		<input type="hidden" name = "page" value ="searchTeamResult" /> -->
		<input type="submit" onsubmit="return sendForm()" value = "전송" />
		
		</form>
</body>
</html>