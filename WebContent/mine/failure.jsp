<%@ page contentType = "text/html" pageEncoding = "GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body  background = "${pageContext.request.contextPath}/images/2.png">
<center>
        <h1>五秒钟后跳转到login页面<a href = "login.jsp">返回登陆页面</a></h1>
<%
       response.setHeader("refresh","5;URL = login.jsp");      
%>
</center>
</body>
</html>