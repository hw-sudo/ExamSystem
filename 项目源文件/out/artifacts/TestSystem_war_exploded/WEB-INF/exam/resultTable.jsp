<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>

</head>
<body>
	<form method="post" action="userServlet?method=batchDel" id="form1">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">历史成绩</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>

					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th>科目</th>
					<th>成绩</th>
					<th>答题时间</th>
				</tr>


				<c:forEach items="${gradeList }" var="grade">
					<tr>
						<td>${grade.paper }</td>
						<td>${grade.score }</td>
						<td>${grade.time }</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {
				window.location.href="userServlet?method=deleteUser&user_id="+id
			}
		}

		var num = 1;
		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (num % 2 == 1) {
					this.checked=true;
				}else {
					this.checked=false;
				}
			});
			num++;
		})

		$("#batchDel").click(function(){
			if(confirm("你确定要批量删除吗?")){
				$("#form1").submit();
			}
		})
	</script>
</body>
</html>