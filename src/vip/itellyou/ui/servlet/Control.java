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
		HttpSession session = req.getSession();//ȡ��session����

       //�û�����yanwenxuan ������123
        if("����".equals(name)&&"123".equals(password)){
	        //resp.setHeader("refresh", "5;URL = success.jsp");//�ͻ�����ת
			req.getRequestDispatcher("success.jsp").forward(req, resp);//�������ת
               session.setAttribute("userid",name);//����½���û����浽session��
	    } else {         //��½ʧ�ܣ�����ʧ��ҳ��
		resp.sendRedirect("failure.jsp");
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
