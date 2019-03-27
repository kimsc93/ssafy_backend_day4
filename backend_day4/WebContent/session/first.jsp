<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>첫번째 페이지입니다.</h1>
	<ul>
		<li><%=request.getParameter("type") %>
		<li><%=request.getAttribute("reqAttr") %>
		<li><%=session.getAttribute("sesAttr") %>
		<li><%=application.getAttribute("appAttr") %>
	</ul>
	<a href = "second">두 번째 서블릿</a>
</body>
</html>