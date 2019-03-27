package com.ssafy.servlet.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieLoginServlet
 */
@WebServlet("/cookie/cookieLogin")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		boolean result = LoginService.getService().canLogin(id, pass);
		
		if(result ) {
			Cookie cookie = new Cookie("loginId",id);
			cookie.setMaxAge(60*60);
			response.addCookie(cookie);
//			request.setAttribute("loginId", id);
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			
			RequestDispatcher disp = request.getRequestDispatcher("main.jsp");
			disp.forward(request, response);
		}else {
			response.sendRedirect("loginFail.jsp");
		}
	}

}
