package vip.itellyou.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 1508578124584893121L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1 
		//2 
		//3 
		request.getRequestDispatcher("/pages/reg.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
