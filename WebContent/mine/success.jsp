<%@ page contentType = "text/html;charset = UTF-8" pageEncoding = "GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import = "java.util.*"%>
<html>
<body background = "${pageContext.request.contextPath}/images/1.png">
<center>
<font color = "white">
<h1>��½�ɹ�</h1>
<% 
      if(session.getAttribute("userid") != null){//�Ѿ����ù����ԣ����Բ�Ϊ��
	 //String name = request.getParameter("username");
	 //response.setHeader("refresh","60;URL = login.jsp");//��ʱ��ת
%>
      <h3>��ӭ<font color = "red"><%=session.getAttribute("userid")%></font>�û���¼<a href = "logout.jsp">ע����</a></h3>
<%
      } else {   //�Ƿ��û���û�е�½������session��Χû�����Դ���
%>
       <h3>���Ƚ���ϵͳ��<a href = "login.jsp">��½</a></h3>
<%
}	
%>

</font>
</center>
</body>
</html>