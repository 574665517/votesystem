package vip.itellyou.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import vip.itellyou.util.filter.MyRequest;

@WebFilter("/*")
public class EncodeFilter implements Filter {
    //记录目标编码的名称
	private String encode;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//向下转型
		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response = (HttpServletResponse)res;
		//在servlet执行之前，设置request，response的CharacterEncoding
		
		//写死了， =>web.xml 写配置
		//req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(this.encode);//处理post方式
		res.setCharacterEncoding(this.encode);
		
		//如果是GET方式提交的，代换req对象成为自己定义的请求类的子类对象
		//在子类中重写了getParameter
		if("GET".equals(request.getMethod().toUpperCase())){//转成大写
			MyRequest mr  = new MyRequest(request);
			mr.setEncode(this.encode);
			req = mr;//换成子类对象
		}
		//功能代码
		//拦截在Servlet代码执行之前执行的
		
		//放行，再往下面传
		chain.doFilter(req,res);
		
		//拦截在Servlet代码执行之后执行的

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//FilterConfig保存web.xml中配置在
		//过滤器中的初始化参数
		this.encode = config.getInitParameter("enc");

	}
	
	@Override
	public void destroy() {

	}

}
