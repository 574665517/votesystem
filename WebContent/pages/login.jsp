<%@ page language="java" import="java.util.*,vip.itellyou.pojo.User" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript">
window.onload = function(){
	var input = document.getElementById("loginBox").getElementsByTagName("input");
	for(i=0; i<input.length; i++) {
		var type = input[i].getAttribute("type");
		if(type == "text" || type == "password") {
			input[i].onfocus = function(){
				this.className += " input-text-over";
			}
			input[i].onblur = function(){
				this.className = this.className.replace(/input-text-over/, "");
			}
		} else if(type == "submit") {
			input[i].onmouseover = function(){
				this.className += " input-submit-over";
			}
			input[i].onmouseout = function(){
				this.className = this.className.replace(/input-button-over/, "");
			}
		}
	}
}
</script>
<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>
<div id="header" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-3" data-genuitec-path="${pageContext.request.contextPath}/login.jsp">
	<img src="${pageContext.request.contextPath}/images/logo.gif" />
</div>
<div id="login" class="wrap">
	<div class="main">
		<div class="corner"></div>
		<div class="introduce">
			<h2>艾特优软件</h2>
			<p>网上调查系统...</p>
		</div>
		<div class="login">
			<h2>用户登录</h2>
			<form method="post" action="${pageContext.request.contextPath}/doLogin">
				<dl id="loginBox">
					<dt>用户名：</dt>
					<dd><input type="text" class="input-text" name="name"  value="${user.name}"/></dd>
					<dt>密　码：</dt>
					<dd><input type="password" class="input-text" name="pwd"  value=""/></dd>
					<dt></dt>
					<dd><input type="checkbox"  name="remember"  value="1"/>10天内免登录</dd>
					<dt></dt>
					<dd><input type="submit" class="input-button" name="submit" value="登录" /> <a href="${pageContext.request.contextPath}/pages/reg.jsp">新用户注册</a></dd>
				</dl>
			</form>
			<div class="error">${message}</div>
			
			<c:remove  var="user"  scope="session"  />
		<c:remove  var="message"  scope="session"  />
		
		</div>
	</div>
</div>
<div class="wrap">
</div>
<div id="footer" class="wrap">
</div>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/scripts/login.js"></script>
</body>
</html>
