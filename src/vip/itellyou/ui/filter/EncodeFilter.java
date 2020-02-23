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
    //��¼Ŀ����������
	private String encode;
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//����ת��
		HttpServletRequest request = (HttpServletRequest)req;
//		HttpServletResponse response = (HttpServletResponse)res;
		//��servletִ��֮ǰ������request��response��CharacterEncoding
		
		//д���ˣ� =>web.xml д����
		//req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(this.encode);//����post��ʽ
		res.setCharacterEncoding(this.encode);
		
		//�����GET��ʽ�ύ�ģ�����req�����Ϊ�Լ��������������������
		//����������д��getParameter
		if("GET".equals(request.getMethod().toUpperCase())){//ת�ɴ�д
			MyRequest mr  = new MyRequest(request);
			mr.setEncode(this.encode);
			req = mr;//�����������
		}
		//���ܴ���
		//������Servlet����ִ��֮ǰִ�е�
		
		//���У��������洫
		chain.doFilter(req,res);
		
		//������Servlet����ִ��֮��ִ�е�

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		//FilterConfig����web.xml��������
		//�������еĳ�ʼ������
		this.encode = config.getInitParameter("enc");

	}
	
	@Override
	public void destroy() {

	}

}
