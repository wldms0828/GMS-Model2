<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div id="menu-box">
		<ul	id="menu">
			<li><a href="">HOME</a></li>
			<li><a href="">ABOUT</a></li>
			<li><a id="moveToAdminMain">ADMIN</a></li>
		
			</ul>
		</div> 
<script>
	document.getElementById('moveToAdminMain').
	addEventListener('click',function(){
		admin.check("${ctx}");
	});
</script>