<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">

<body>
	<div id="wrapper"></div>
	<div id="header">

	</div>

	<!-- 		header end -->
	<div >

	</div>
	<!-- 		content end -->
	<div id="footer"></div>

<script>
		function move(domain, action, page) {
			alert('클릭 테스트 성공${ctx}');
			console.log('클릭 테스트 성공${ctx}')
			location.href = "${ctx}/" + domain + ".do?action=" + action
					+ "&page=" + page;
		}
		function sendForm(){
			return true;
		}
</script>
</body>
</html>

