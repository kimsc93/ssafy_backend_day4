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
	<h1><%=session.getAttribute("loginId") %>님의 장바구니입니다. </h1>
	
	<h1>장바구니 목록</h1>
	<h2><%=session.getAttribute("cart") %></h2>
	<a href="buy">구매하기</a>
	<jsp:include page="/include/footer.jsp"></jsp:include>
	
</body>
</html>