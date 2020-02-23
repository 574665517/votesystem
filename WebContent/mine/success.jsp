<%@ page contentType = "text/html;charset = UTF-8" pageEncoding = "GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page import = "java.util.*"%>
<html>
<body background = "${pageContext.request.contextPath}/images/1.png">
<center>
<font color = "white">
<h1>登陆成功</h1>
<% 
      if(session.getAttribute("userid") != null){//已经设置过属性，所以不为空
	 //String name = request.getParameter("username");
	 //response.setHeader("refresh","60;URL = login.jsp");//定时跳转
%>
      <h3>欢迎<font color = "red"><%=session.getAttribute("userid")%></font>用户登录<a href = "logout.jsp">注销！</a></h3>
<%
      } else {   //非法用户，没有登陆过，则session范围没有属性存在
%>
       <h3>请先进行系统的<a href = "login.jsp">登陆</a></h3>
<%
}	
%>

</font>
</center>
</body>
</html>