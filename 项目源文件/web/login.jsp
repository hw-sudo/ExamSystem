<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>WELCOME! 在线考试系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- -->
<script>
	var __links = document.querySelectorAll('a');
	function __linkClick(e) {
		parent.window.postMessage(this.href, '*');
	};
	for (var i = 0, l = __links.length; i < l; i++) {
		if (__links[i].getAttribute('data-t') == '_blank') {
			__links[i].addEventListener('click', __linkClick, false);
		}
	}
</script>
<script src="js/jquery.js"></script>
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
</head>
<body>
	<!-- contact-form -->
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1>欢迎登录考试系统</h1>
				<div class="alert-close"></div>
			</div>
			<form action="<%=path%>userServlet" method="get">
				<input type="hidden" name="method" value="login">
				<li><input name="username" type="text" class="text"
					value="Username" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Username';}"><a
					href="#" class=" icon user"></a></li>
				<div class="clear"></div>
				<li><input name="password" type="password" value="Password"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
					<a href="#" class="icon lock"></a></li>
				<div class="clear"></div>
				<div class="submit">
					<input type="submit" value="Sign in">
					<h4>
						<a href="#">忘记密码 ?</a>
					</h4>
					<h4>
						<a href="<%=path%>register.jsp">注册 ?</a>
					</h4>
					<br>
					<br> <span style="color: red; font-size: 10px">${login_msg}</span>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<!--- footer --->
	<div class="footer">
		<p>Made by xian</p>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>