<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--jsp:include의 목적 : 화면 재사용 .여기저기서 오니까 절대경로 쓰자--%>
	<jsp:include page="/include/header.jsp"></jsp:include>
	<%--@include의 목적은 logic 재사용 --%>
	<%@include file="sub.jsp" %>
	<%=companyName %>
	<%=sayHello("홍길동") %>
	<jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html>