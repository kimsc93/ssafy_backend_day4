package com.ssafy.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/cart/buy")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에 담긴 상품 구매
		HttpSession session = request.getSession();
		Object cart = session.getAttribute("cart");
		session.removeAttribute("cart");	//세션은 데이터누적되지 않도록 관리!!
		//구매처리
		System.out.println(cart+"의 상품을 구매합니다.");
		response.sendRedirect("../cookie/main.jsp");
	}
	
}
