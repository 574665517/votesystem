package vip.itellyou.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 687434665454267977L;

	/**
	 *发回 浏览器端要求的登录表单
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//3 衔接JSP：域对象，转发
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
