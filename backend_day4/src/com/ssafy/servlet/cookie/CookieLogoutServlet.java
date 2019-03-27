package com.ssafy.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieLogoutServlet
 */
@WebServlet("/cookie/logout")
public class CookieLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//유효기간이 0인 쿠키 loginID 키를 가진 쿠키를 생성후 내려보내면 끝
		Cookie cookie = new Cookie("loginId","some");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		//세션의 완전 종료
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("loginForm.jsp");
	}
}
