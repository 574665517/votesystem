package vip.itellyou.util.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
    private String encode;
   
    public void setEncode(String encode){
    	this.encode = encode;
    }
    
	public MyRequest(HttpServletRequest request) {
		super(request);
	}
	
	public String getParameter(String name){
		//创建新字符串，编码使用目标编码
		String result = null;
		try {
			//调用父类的getParamter用ISO-8859-1编码读取浏览器提交的数据
			//然后用ISO-8859-1编码将字符串转换成字节数组
			byte[] bs  = super.getParameter(name).getBytes("ISO-8859-1");
			//使用字节数组重新构建新字符串，新字符串的编码是指定的编码
			result =  new String(bs,this.encode);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

}
