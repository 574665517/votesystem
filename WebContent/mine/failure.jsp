<%@ page contentType = "text/html" pageEncoding = "GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body  background = "${pageContext.request.contextPath}/images/2.png">
<center>
        <h1>�����Ӻ���ת��loginҳ��<a href = "login.jsp">���ص�½ҳ��</a></h1>
<%
       response.setHeader("refresh","5;URL = login.jsp");      
%>
</center>
</body>
</html>