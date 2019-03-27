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
 * Servlet implementation class CheckCookieServlet
 */
@WebServlet("/cookie/checkcookie")
public class CheckCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿의 역할 : 입력값 검증, 모델 연동, 뷰 연동
		//1. 쿠키 확인
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		String loginId = null;
		if(cookies != null) {
			for(Cookie c : cookies ) {
				//로그인 아이디와 연관된 쿠키 찾기 : loginId
				if(c.getName().equals("loginId")) {	//로그인 한 경험이 있는 사용자
					flag=true;
					loginId = c.getValue();
					break;
				}
			}
		}
		//2.이전 로그인 여부에 따른 뷰 연동
		String target = "loginForm.jsp";
		if(flag) {
			target = "main.jsp";
//			request.setAttribute("loginId", loginId);
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			
			RequestDispatcher disp = request.getRequestDispatcher(target);
			disp.forward(request, response);
		}
		else {
			response.sendRedirect(target);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
