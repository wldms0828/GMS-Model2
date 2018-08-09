<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
<jsp:include page="head.jsp" />
<body>
	<div id="wrapper"></div>
	<div id="header">
		<jsp:include page="titleBox.jsp" />
		<jsp:include page="loginBox.jsp" />
		<jsp:include page="menuBox.jsp" />
	</div>

	<!-- 		header end -->
	<div >
		<jsp:include page="contentBox.jsp" />
	</div>
	<!-- 		content end -->
	<div id="footer"></div>
	<jsp:include page="footerBox.jsp" />
<script>
	common.main('${ctx}');
</script>
</body>
</html>

