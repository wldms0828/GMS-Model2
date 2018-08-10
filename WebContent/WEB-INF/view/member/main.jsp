<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<body>

	<div id="wrapper"></div>
	<div id="header">

	</div>

	<!-- 		header end -->
	<div id="content" >
	이동페이지 : ${pagename }
		<c:choose>
			<c:when test="${pagename  eq 'add'}">
				<jsp:include page="add.jsp">
			</c:when>
			<c:when test="${pagename  eq 'login'}">
				<jsp:include page="login.jsp">
			</c:when>
			<c:when test="${pagename  eq 'search'}">
				<jsp:include page="login.jsp">
			</c:when>
			<c:otherwise>
				<jsp:include page="retrieve.jsp">
			</c:otherwise>
		</c:choose>
	</div>
	<!-- 		content end -->
	<div id="footer"></div>

<script>
	member.main('${ctx}');
</script>
</body>
</html>

