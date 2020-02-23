package vip.itellyou.ui.filter;

import java.io.* ;
import javax.servlet.* ;

public class MyFilter implements Filter {
	private String encoding  = null;
	public void init(FilterConfig config) throws ServletException{
		// ���ճ�ʼ���Ĳ���
		this.encoding = config.getInitParameter("encoding") ;//ȡ�ó�ʼ������
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException,ServletException {
		if(request.getCharacterEncoding()==null){
		      if(this.encoding!=null) {
				  request.setCharacterEncoding(this.encoding);
			  }
		}
		response.setContentType("text/html;charset=GBK");
	    chain.doFilter(request,response) ;
	}
	public void destroy(){
		this.encoding=null;
	}
}