package vip.itellyou.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vip.itellyou.pojo.Option;
import vip.itellyou.pojo.Subject;
import vip.itellyou.pojo.User;
import vip.itellyou.service.SubjectService;
import vip.itellyou.service.impl.SubjectServiceImpl;
import vip.itellyou.util.exception.RuleException;
import vip.itellyou.util.format.DateFormatter;

public class DoAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248489925470392372L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 1 ��ȡ������ύ�����ݣ�������⣬ѡ�����ͣ�����ѡ�������
		String sid = request.getParameter("id");
		String title = request.getParameter("title");
		int number = Integer.parseInt(request.getParameter("number"));
		//��һ��ҳ���ж������Ԫ��ͬ�������������Խ��ն��Ԫ���е�valueֵ
		String[] os = request.getParameterValues("options");		
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        
		Subject subject = new Subject();		
		subject.setTitle(title);
		subject.setNumber(number);
		for(String ocontent:os){
			Option op = new Option();
			op.setContent(ocontent);
			
			subject.getOptions().add(op);
		}

		try {			
			// 2 ����ҵ���߼���Ķ��󣬵���ҵ�񷽷�����
			SubjectService subjectService = new SubjectServiceImpl();
			if(sid==null || sid.trim().length()==0){
				subjectService.add(subject,(User)request.getSession().getAttribute(User.SESSION_NAME));
			}
			else{
				subject.setId(Integer.parseInt(sid));
				subject.setStartTime(DateFormatter.toLong(startTime));
				subject.setEndTime(DateFormatter.toLong(endTime));
				subjectService.modify(subject,(User)request.getSession().getAttribute(User.SESSION_NAME));
			}
			// 3�ض���ͶƱ��Ŀ�б�ҳ��			
			response.sendRedirect(request.getContextPath() + "/list");
		} catch (RuleException e) {
			HttpSession session = request.getSession();
			session.setAttribute("subject", subject);
			session.setAttribute("message", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/m/add");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}