package vip.itellyou.ui.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vip.itellyou.pojo.User;
import vip.itellyou.service.UserService;
import vip.itellyou.service.impl.UserServiceImpl;
import vip.itellyou.util.exception.RuleException;

/**
 * Servlet implementation class DoRegister
 */
//@WebServlet("/DoRegister")//��ע������õȼ��� ��web.xml�����õĸ�servlet��<servlet-mapping>Ԫ����<url-pattern>�����ã�
public class DoRegServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ע����е������Ѿ���д��ϣ��ύ����
		//1��ȡ������ύ������
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String confirmPwd = request.getParameter("confirmPwd");
		
		//ʵ���������Ϊ��������
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setConfirmPwd(confirmPwd);
		
		try {
			//2 ����ҵ���߼����󣬵���ҵ�񷽷�2�޸�����
			UserService service = new UserServiceImpl();
			service.register(user);
			//3 �ν�JSP���ض���/login��¼ҳ��
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (RuleException e) {
			//��Ϊ�û���������Υ��ҵ�����
			//�������ݻ��ԣ����Ƿ���ע���  reg.jsp
			//ͨ������󴫻ؽ��յ������ݣ�����ԭ��
			request.setAttribute("user", user);
			request.setAttribute("message", e.getMessage());
			request.getRequestDispatcher("/pages/reg.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
