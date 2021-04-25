<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/10/12
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<center>
  <a href="questionServlet?method=getPaperList">开始考试</a>
</center>
  </body>
</html>
