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
@WebServlet("/session/second")
public class SecondServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서버에서 정보를 저장하는 영역에 정보를 저장하자.
		System.out.println("request : "+ request.getAttribute("reqAttr"));
		
		HttpSession session = request.getSession();
		System.out.println("session : "+ session.getAttribute("sesAttr"));
		
		ServletContext application = request.getServletContext();
		System.out.println("application : "+application.getAttribute("appAttr"));
		response.sendRedirect("second.jsp");
	}
}
