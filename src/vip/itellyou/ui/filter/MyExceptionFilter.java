package vip.itellyou.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyExceptionFilter implements Filter {

	private String errorPage;
	private String fileName;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//�쳣�����ں����Ĺ�������Servlet��
		try{
			//���У�����ȥִ�й�������Servlet�еĴ���
			chain.doFilter(request, response);
		}catch(Exception ex){
			//��¼��־ ��Log4J
			//��ת��������ҳ�棬ת����Ŀ���ַ
			request.setAttribute("ex", ex);
			request.getRequestDispatcher(this.errorPage).forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.errorPage = filterConfig.getInitParameter("errorPage");
		this.fileName = filterConfig.getInitParameter("fileName");
	}

}
