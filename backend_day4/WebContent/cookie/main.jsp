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
	
	<h1>즐거움이 가득한.. 여기는 main입니다.</h1>
	<%=session.getAttribute("loginId") %>님 반갑습니다.
	<a href="logout">로그아웃</a>
	<hr>
	<h1>상품 목록</h1>
	<input type="text" id="product" placeholder="구매하려는 상품을 입력하세요.">
	<input type="button" value="담기" id="add">
	
	<h1>장바구니 목록</h1>
	<div id="cartInfo">
		<%
			Object cart = session.getAttribute("cart");
			if(cart!=null){
				out.println(cart);
			}
		%>
	</div>
	<br><a href="../cart/cart.jsp">장바구니</a>
	<jsp:include page="/include/footer.jsp"></jsp:include>
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	//add버튼이 클릭 될 때 cart로 등록된 서블릿으로 상품 목록을 post전송하시오.
	//응답 결과(상품의 목록)을 cartInfo에 출력한다.
	$("#add").on("click",function(){
		$.ajax({
			url:"../cart/cart",
			type:"post" ,
			data: {product:$("#product").val()},	 // object
			success: function(rexTxt){
				$("#cartInfo").html(rexTxt);
			},
			error:function(){
				alert("장바구니 추가 실패");
			}
		});
	});
	
	
</script>
</html>
