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
//@WebServlet("/DoRegister")//该注解的作用等价于 在web.xml中配置的该servlet的<servlet-mapping>元素中<url-pattern>的配置，
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
		//注册表单中的数据已经填写完毕，提交处理
		//1获取浏览器提交的数据
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String confirmPwd = request.getParameter("confirmPwd");
		
		//实体类对象作为数据载体
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setConfirmPwd(confirmPwd);
		
		try {
			//2 创建业务逻辑对象，调用业务方法2修改数据
			UserService service = new UserServiceImpl();
			service.register(user);
			//3 衔接JSP：重定向到/login登录页面
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (RuleException e) {
			//因为用户操作不当违反业务规则
			//进行数据回显：还是发回注册表单  reg.jsp
			//通过域对象传回接收到的数据，错误原因
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
