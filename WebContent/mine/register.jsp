<%@ page contentType = "text/html" pageEncoding = "GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ע   ��</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
<body>
<div id="header" class="wrap" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-4" data-genuitec-path="/VoteSite/WebRoot/register.jsp">
	<img src="images/logo.gif" />
</div>
<div id="navbar" class="wrap">
	<div class="search">
	</div>
</div>
<div id="register" class="box">
	<h2>���û�ע��</h2>
	<div class="content">
	   <form action="${pageContext.request.contextPath}/DoRegister" method="post" >
			<dl>				
				<dt>�û�����</dt>
				<dd><input type="text" class="input-text" name="name" value=""/></dd>
				<dt>���룺</dt>
				<dd><input type="password" class="input-text" name="pwd" value=""/></dd>
				<dt>ȷ�����룺</dt>
				<dd><input type="password" class="input-text" name="confirmPwd" value=""/></dd>
				<dt></dt>
				<dd><input type="submit" class="input-button" name="submit" value="" /></dd>
			</dl>
		</form>
		<div class="error"></div>
	</div>
</div>
<div id="footer" class="wrap">
</div>
</body>
</html>
