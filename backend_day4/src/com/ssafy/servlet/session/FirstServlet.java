package com.ssafy.servlet.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/session/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에서 정보를 저장하는 영역에 정보를 저장하자.
		request.setAttribute("reqAttr", "reqAttr");
		
		HttpSession session = request.getSession();
		session.setAttribute("sesAttr", "sesAttr");
		//web.xml설정 재정의
		session.setMaxInactiveInterval(60*5);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("appAttr", "appAttr");
		
		//파라미터에 따라 분기처리
		String type = request.getParameter("type");
		String target = "first.jsp";
		if(type.equals("forward")) {
			RequestDispatcher disp = request.getRequestDispatcher(target);
			disp.forward(request, response);
		}
		else {
			response.sendRedirect(target);
		}
		
	}

}
