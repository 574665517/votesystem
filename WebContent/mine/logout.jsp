<%@ page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title>ywx</title></head>
<body>
<%
	response.setHeader("refresh","5;URL=login.jsp") ;
	session.invalidate() ;	// 注销，表示当前的session失效
%>
<h3>您已成功退出本系统，五秒后跳转回首页！</h3>
<h3>如果没有跳转，请按<a href="login.jsp">这里</a></h3>
</body>
</html>