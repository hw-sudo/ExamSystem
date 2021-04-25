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
    <link rel="stylesheet" href="css/layui.css" >
    <script src="js/layui.js" charset="utf-8"></script>
    <style>
        a{
            text-decoration:none;
            color: white;
        }
    </style>
</head>

<body>
<div class="layui-card-header">请选择科目</div>
<div class="layui-card-body">

      <c:forEach items="${paperList }" var="paper">
          <div class="layui-col-xs3">
        <div class="grid-demo grid-demo-bg1">
            <button type="button" class="layui-btn layui-btn-radius" style="margin-top: 20px"><a href="questionServlet?method=getPaperQuestion&paper=${paper }">${paper }</a></button>
        </div> </div>
      </c:forEach>


</div>

</body>


</html>