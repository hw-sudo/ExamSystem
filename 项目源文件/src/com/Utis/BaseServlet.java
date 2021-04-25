package com.Utis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1.获取jsp传递的方法
        //2.反射对应的Servlet类
        //3.获取需要调用的方法
        //4.获取返回值
        //5.异常判断
        String method=req.getParameter("method");
        Class servlet=this.getClass();
        //Class.getMethod(方法名,方法参数类……）
        Method method1 = null;
        try {
            method1=servlet.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //进行method判空
        if(method.isEmpty()||method.trim().isEmpty()) {
            throw new RuntimeException("当前方法为空");
        }
        //调用指定方法并获取返回值
        String result;
        //method.invoke(形参)
        try {
            result=(String) method1.invoke(this,req,resp);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("当前方法执行有问题");
        }

        if(result.isEmpty()||result.trim().isEmpty()){
            // super.service(req,resp);表示承接父类servlet
            //return；表示终止当前servlet
//            super.service(req,resp);
            return;
        }
        //跳转界面
        req.getRequestDispatcher(result).forward(req,resp);
    }
}
