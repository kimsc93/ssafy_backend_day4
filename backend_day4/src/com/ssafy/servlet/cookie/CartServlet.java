package com.ssafy.servlet.cookie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터에서 product추출 -->모델연동-->View처리
		String product = request.getParameter("product");
		//모델 연동(DB에저장)
		
		//session에 저장
		HttpSession session = request.getSession();
		Object cartObj = session.getAttribute("cart");//이전에 카트가 있었는지 
		List<String> cart;
		if(cartObj==null) {	//처음 쇼핑하는 경우 - 새로운 카트준비
			cart = new ArrayList<>();
			session.setAttribute("cart", cart);
		}
		else {	//기존에 쇼핑 했었음
			cart = (ArrayList<String>) cartObj;
		}
		cart.add(product);
		response.getWriter().append(cart.toString());
	}
	
	
}
