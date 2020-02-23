package vip.itellyou.ui.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.itellyou.pojo.Subject;
import vip.itellyou.service.SubjectService;
import vip.itellyou.service.impl.SubjectServiceImpl;

public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = -3205849245738601948L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			//2 创建业务逻辑对象，调用业务方法获取结果
			SubjectService subjectService = new SubjectServiceImpl();
			List<Subject> list = subjectService.getSubjects();
			
			//3 衔接JSP
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pages/list.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
