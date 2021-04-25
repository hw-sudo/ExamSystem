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
<script src="<%=path%>/js/jquery.js"></script>
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
				<h1>注册</h1>
				<div class="alert-close"></div>
			</div>
			<form action="userServlet" method="get" id="form">
				<input type="hidden" name="method" value="register">
				<li><input name="username" type="text" class="text" placeholder="请输入用户名">
					</li>
				<li><input name="password" type="password" placeholder="密码">
					</li>
				<li><input name="name" type="text" placeholder="真实姓名">
					</li>
				<li><input name="telephone" type="text" placeholder="请输入电话">
				</li>
				<li><input name="sex" type="text" placeholder="请输入性别">
					</li>
				<li><input name="age" type="text" placeholder="请输入年龄">
					</li>
				<li><input name="role" type="text" placeholder="请输入角色"></li>
				<div class="clear"></div>
				<div class="submit">
					<input type="submit" value="Sign up" id="submit">
					<h4>
						<a href="login.jsp" style="float: right">已有账户，前往登录</a>
					</h4>
					<br>
					<br> <span style="color: red; font-size: 10px">${login_msg}</span>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>

	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>342
</body>
</html>