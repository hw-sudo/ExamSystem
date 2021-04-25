package com.Controller;

import com.Entity.Grade;
import com.Entity.User;
import com.Entity.single;
import com.Service.GradeService;
import com.Service.QuestionService;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "QuestServlet",urlPatterns = "/questionServlet")
public class QuestionController extends HttpServlet {
    private QuestionService questionService=new QuestionService();
    private GradeService gradeService=new GradeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if ("addSingle".equals(method)) {
//            addSingle(req,resp);
        }else if ("getPaperList".equals(method)) {
            getPaperList(request,response);
        }else if ("getPaperQuestion".equals(method)) {
            getPaperQuestion(request,response);
        }else if ("submitPaper".equals(method)) {
            submitPaper(request,response);
        }else if ("toIndexPage".equals(method)) {
//            toIndexPage(req,resp);
        }else {
            System.out.println("method找不到："+method);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    //生成对应科目卷子集
    private void getPaperQuestion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取科目名
        String paper = req.getParameter("paper");
        //调用查询服务
        List<single> singles =  questionService.queryPaperSingle(paper);
        //获取卷子集
        req.setAttribute("singleList", singles);
        //转发至卷子界面
//        req.getRequestDispatcher("WEB-INF/exam/paper.jsp").forward(req, resp);
        req.getRequestDispatcher("WEB-INF/exam/exam1.jsp").forward(req, resp);
    }
    //获取提交试卷，并计算分数
    private void submitPaper(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paper = req.getParameter("paper");
        List<single> singles = questionService.queryPaperSingle(paper);
        //父类引用指向子类对象（多态的体现）
        List<String> rightAnswers = new ArrayList<String>();//定义存储正确答案的集合rightAnswers
        for (single single : singles) {
            rightAnswers.add(single.getAnswer());//往rightAnswers集合添加每一个正确得答案
        }
        Enumeration<String> parameterNames = req.getParameterNames();//获取请求所有的参数名
        int rightCount = 0;											//正确的题目数
        List<String> yourAnswers = new ArrayList<String>();			//你的答案集合
        while (parameterNames.hasMoreElements()) {					//当枚举有下一个元素时，进入循环
            String pName = parameterNames.nextElement();			//获取下一个枚举元素，作为参数名
            String yourAnswer = req.getParameter(pName);			//当前枚举元素所对应的参数值
            System.out.println(pName + " : " + yourAnswer);
            if (pName.startsWith("answer")) {						//如果当前参数名以answer开头，即单选框
                int index =  Integer.parseInt(pName.substring(6));	//通过字符串截取，把参数名所对应的下标截取出来
                String rightAnswer = rightAnswers.get(index);		//通过下标，访问正确答案集合，获取所对应题的正确答案
                if (rightAnswer.equals(yourAnswer)) {				//如果你的答案和正确答案相等
                    rightCount++;									//正确的题目数+1
                }
                yourAnswers.add(yourAnswer);						//把你的答案添加到你的答案集合中
            }
        }
        int score = rightCount * (100/rightAnswers.size());			//分数=正确数目 * 每道题的分值占比
        //向页面返回数据
        req.setAttribute("yourAnswers", yourAnswers);
        req.setAttribute("rightAnswers", rightAnswers);
        req.setAttribute("rightCount", rightCount);
        req.setAttribute("score", score);
        //获取登录用户的session ,并把成绩打入库中
        User user = (User)req.getSession().getAttribute("user");
        Grade grade = new Grade();
        grade.setUser_id(user.getUser_id());
        grade.setPaper(paper);
        grade.setScore(score);
        gradeService.addGrade(grade);
        //返回结果集
        req.getRequestDispatcher("WEB-INF/exam/result.jsp").forward(req, resp);	//通过请求转发的方式，跳转页面
    }
    //获取科目集
    private void getPaperList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> papers =  questionService.queryPaperList();
        System.out.println(papers);
        req.setAttribute("paperList", papers);
        req.getRequestDispatcher("WEB-INF/exam/selectPaper2.jsp").forward(req, resp);
    }
}
