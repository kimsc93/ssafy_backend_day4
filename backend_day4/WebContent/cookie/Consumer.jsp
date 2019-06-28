<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>

	<h1>쿠키 확인1</h1>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies !=null){
			for(Cookie c: cookies){ 
				out.println(c.getName()+" : "+URLDecoder.decode(c.getValue(),"utf-8")+"<br>");
			}
		}
	%>
	<jsp:include page="/include/footer.jsp"></jsp:include>
	
</body>
</html>