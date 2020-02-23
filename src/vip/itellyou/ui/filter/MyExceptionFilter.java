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
		//异常发生在后续的过滤器和Servlet中
		try{
			//放行，就是去执行过滤器和Servlet中的代码
			chain.doFilter(request, response);
		}catch(Exception ex){
			//记录日志 ，Log4J
			//跳转到错误处理页面，转发到目标地址
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
