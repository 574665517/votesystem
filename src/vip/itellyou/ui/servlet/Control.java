package vip.itellyou.ui.servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Control extends HttpServlet {

	private static final long serialVersionUID = 9066925700518796474L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();//取得session对象

       //用户名是yanwenxuan 密码是123
        if("熊熊".equals(name)&&"123".equals(password)){
	        //resp.setHeader("refresh", "5;URL = success.jsp");//客户端跳转
			req.getRequestDispatcher("success.jsp").forward(req, resp);//服务端跳转
               session.setAttribute("userid",name);//将登陆的用户名存到session中
	    } else {         //登陆失败，跳到失败页面
		resp.sendRedirect("failure.jsp");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
