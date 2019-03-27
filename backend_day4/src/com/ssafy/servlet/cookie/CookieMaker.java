package com.ssafy.servlet.cookie;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieMaker
 */
@WebServlet("/cookie/Maker")
public class CookieMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유효기간이 다른 3개의 쿠키를 만들어 보내기
		Cookie c1 = new Cookie("name","홍길동");
		c1.setMaxAge(60*2);//유효기간이 2분인 쿠키
		response.addCookie(c1);
		
		Cookie c2 = new Cookie("phone",URLEncoder.encode("010=1234,5678", "utf-8"));
		c2.setMaxAge(-1);//유효기간이 없는 쿠키
		response.addCookie(c2);
		
		Cookie c3 = new Cookie("ssn","000000-0000");
		c3.setMaxAge(0);//
		response.addCookie(c3);
		
//		response.getWriter().append("Served at: ").append("쿠키전송 완료");
		response.sendRedirect("../Consumer.jsp");		
	}
}
