<%@ page contentType = "text/html" pageEncoding = "GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
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
<div id="header" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-3" data-genuitec-path="/VoteSite/WebRoot/login.jsp">
	<img src="${pageContext.request.contextPath}/images/logo.gif" />
</div>
<div id="login" class="wrap">
	<div class="main">
		<div class="corner"></div>
		<div class="introduce">
			<h2>���������</h2>
			<p>���ϵ���ϵͳ...</p>
		</div>
		<div class="login">
			<h2>�û���¼</h2>
			<form action="Control" method="post" >
				<dl id="loginBox">
					<dt>�û�����</dt>
					<dd><input type="text" class="input-text" name="username"  value="����"/></dd>
					<dt>�ܡ��룺</dt>
					<dd><input type="password" class="input-text" name="password"  value="123"/></dd>
					<dt></dt>
					<dd><input type="checkbox"  name="remember"  value="1"/>10�������¼</dd>
					<dt></dt>
					<dd><input type="submit" class="input-button" name="submit" value="��¼" /> <a href="${pageContext.request.contextPath}/register.jsp">���û�ע��</a></dd>
				</dl>
			</form>
			<div class="error"></div>
		</div>
	</div>
</div>
<div class="wrap">
</div>
<div id="footer" class="wrap">
</div>
</body>
</html>
