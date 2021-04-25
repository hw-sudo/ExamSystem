<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>在线考试系统</title>

<link href="<%=path%>css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>css/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>css/test.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>js/jquery.js"></script>

<!--时间js-->
<!-- <script src="js/jquery.countdown.js"></script> -->
<script>
	/* var maxtime = 90 * 60;  *///一个小时，按秒计算，自己调整!  
	var maxtime = 10 * 60;
	timer = setInterval("cd()", 1000);

	function cd() {
		if (maxtime >= 0) {
			minutes = Math.floor(maxtime / 60);
			seconds = Math.floor(maxtime % 60);
			if (seconds >= 0 && seconds < 10) {
				seconds = "0" + seconds;
			}
			if (minutes >= 0 && minutes < 10) {
				minutes = "0" + minutes;
			}

			msg = "倒计时" + minutes + ":" + seconds;

			/* document.all["countdown"].innerHTML = msg; */
			$("#countdown").html(msg);

			--maxtime;
		} else {
			clearInterval(timer);
			alert("时间到，已自动交卷!");
			$("#submitPaper").click();

		}
	}
	$(function() {
		$('li.option').click(
				function() {
					var examId = $(this).closest('.test_content_nr_main')
							.closest('li').attr('id'); // 得到题目ID
					var cardLi = $('a[href=#' + examId + ']'); // 根据题目ID找到对应答题卡
					// 设置已答题
					if (!cardLi.hasClass('hasBeenAnswer')) {
						cardLi.addClass('hasBeenAnswer');
					}

				});

	});
</script>
<style>
.hasBeenAnswer {
	background: #5d9cec;
	color: #fff;
}
</style>

</head>
<body>
	<div class="main">
		<!--nr start-->
		<div class="test_main">
			<div class="nr_left">
				<div class="test">
					<form action="questionServlet?method=submitPaper&paper=${param.paper}"
						method="post">
						<div class="test_title">
							<p class="test_time">
								<b id="countdown"></b>
							</p>
							<font><input id="submitPaper" type="submit"
								name="test_jiaojuan" value="交卷"></font>
						</div>

						<div class="test_content">
							<div class="test_content_title">
								<h2>单选题</h2>
								<p>
									<span>共</span><i class="content_lit"></i><span>${fn:length(singleList)}题，</span><span>合计</span><i
										class="content_fs">100</i><span>分</span><span>&nbsp;&nbsp;每题${score}分</span>
								</p>
							</div>
						</div>
						<div class="test_content_nr">
							<ul>
								<c:forEach items="${singleList}" var="question" varStatus="stat">
									<li id="q${stat.count}">
										<div class="test_content_nr_tt">
											<i>${stat.count}</i>${question.subject}<font></font>
										</div>
										<div class="test_content_nr_main">
											<ul>
												<li class="option"><input type="radio"
													class="radioOrCheck" name="answer${stat.index}"
													id="q${stat.count }opt1" value="A"  /> <label
													for="q${stat.count }opt1"> A.
														<p class="ue" style="display: inline;">${question.option_A }</p>
												</label></li>

												<li class="option"><input type="radio"
													class="radioOrCheck" name="answer${stat.index}"
													id="q${stat.count }opt2" value="B"  /> <label
													for="q${stat.count }opt2"> B.
														<p class="ue" style="display: inline;">${question.option_B }</p>
												</label></li>

												<li class="option"><input type="radio"
													class="radioOrCheck" name="answer${stat.index}"
													id="q${stat.count }opt3" value="C"/> <label
													for="q${stat.count }opt3"> C.
														<p class="ue" style="display: inline;">${question.option_C }</p>
												</label></li>

												<li class="option"><input type="radio"
													class="radioOrCheck" name="answer${stat.index}"
													id="q${stat.count }opt4" value="D" /> <label
													for="q${stat.count }opt4"> D.
														<p class="ue" style="display: inline;">${question.option_D }</p>
												</label></li>
												<input name="answer${stat.index}" type="hidden" value="null">

											</ul>
										</div>
									</li>
								</c:forEach>


							</ul>
						</div>


					</form>
				</div>

			</div>
			<div class="nr_right">
				<div class="nr_rt_main">
					<div class="rt_nr1">
						<div class="rt_nr1_title">
							<h1>答题卡</h1>
						</div>

						<div class="rt_content">
							<div class="rt_content_tt">
								<h2>单选题</h2>
								<p>
									<span>共</span><i class="content_lit">${fn:length(singleList) }</i><span>题</span>
								</p>
							</div>
							<div class="rt_content_nr answerSheet">
								<ul>
									<c:forEach items="${singleList }" var="question" varStatus="stat">
										<li><a href="#q${stat.count }">${stat.count }</a></li>
									</c:forEach>



								</ul>
							</div>
						</div>


					</div>

				</div>
			</div>
		</div>
		<!--nr end-->
		<div class="foot"></div>
	</div>



	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei';">

	</div>
</body>
</html>
