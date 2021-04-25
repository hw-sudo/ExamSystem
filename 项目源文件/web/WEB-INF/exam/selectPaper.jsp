<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>考试科目</title>
	<link rel="stylesheet" href="<%=path%>/css/layui.css"  media="all">
	<style>
		a{
			text-decoration:none;
		}
	</style>
</head>

<body>
<center>请选择科目</center>
<fieldset class="layui-elem-field site-demo-button">
		<c:forEach items="${paperList }" var="paper">
			<button type="button" class="layui-btn layui-btn-primary layui-btn-radius"><a href="questionServlet?method=getPaperQuestion&paper=${paper }">${paper }</a></button>
		</c:forEach>
</fieldset>
</body>
<script src="/js/layui.js" charset="utf-8"></script>
</html>