<%@ page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title>ywx</title></head>
<body>
<%
	response.setHeader("refresh","5;URL=login.jsp") ;
	session.invalidate() ;	// ע������ʾ��ǰ��sessionʧЧ
%>
<h3>���ѳɹ��˳���ϵͳ���������ת����ҳ��</h3>
<h3>���û����ת���밴<a href="login.jsp">����</a></h3>
</body>
</html>