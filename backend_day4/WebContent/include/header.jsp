<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#title{
		text-align:center;
	}
	#login{
		text-align:right;
	}
</style>
<h1 id="title">Welcome!!!</h1>
<br>
<div id="login">
	<span id="login">
<%
	Object id = session.getAttribute("loginId");
	if(id!=null){
		out.println(id+"님 반갑습니다.");
	}
	else{
		out.println("로그인 후 사용해주세요.");
	}
%>
	</span>
</div>
<hr>
