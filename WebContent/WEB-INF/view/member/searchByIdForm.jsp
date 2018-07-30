<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<jsp:include page="../common/head.jsp" />
<body>
<form action="${ctx}/member.do">

<h3>USERID : <input type="text" name = "USERID" /></h3>

<input type="hidden" name = "action" value = "retrieve" />
<input type="hidden" name = "page" value = "searchByIdResult" />
<input type="submit" onsubmit="return sendForm()" value = "전송" />
</form>
	
</body>
</html>