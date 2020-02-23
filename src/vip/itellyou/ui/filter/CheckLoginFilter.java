package vip.itellyou.ui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vip.itellyou.pojo.User;

public class CheckLoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;//����
		HttpServletResponse res = (HttpServletResponse)response;

		//���˵�һЩ����Ҫ�˹��ܵ������ַ
//		if(req.getRemoteAddr().contains("/reg")){
//			chain.doFilter(request, response);
//		}
		//������������web.xml�ļ�������
		// url-pattern: /m/*
		
		
		//����Ƿ��¼(session ��ȡ�û�����)
		
		HttpSession session = req.getSession();
		if(session.getAttribute(User.SESSION_NAME) == null){
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
