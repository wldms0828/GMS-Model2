<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=application.getContextPath()%>" />

<!doctype html>
<html lang="en">
<jsp:include page="common/head.jsp"></jsp:include>
<body>
	<div id="wrapper"></div>
	<div id="header">
		<jsp:include page="common/titleBox.jsp" />
		<jsp:include page="common/loginBox.jsp" />
	</div>
	<jsp:include page="common/menuBox.jsp" />
	<!-- 		header end -->
<div id="content">
		<jsp:include page="common/contentBox.jsp" />
	</div>
	<!-- 		content end -->
	<div id="footer"></div>
	<jsp:include page="common/footerBox.jsp"/>
</body>
</html>

