package com.Controller;

import com.Entity.User;
import com.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserController",urlPatterns = "/userServlet")
public class UserController extends HttpServlet {
    private UserService userService=new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method.equals("login"))
            login(request,response);
        if(method.equals("register"))
            register(request,response);

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setSex(request.getParameter("sex"));
        user.setRole(request.getParameter("role"));
        user.setTelephone(request.getParameter("telephone"));
        //调用服务
        userService.insert(user);
        //跳转界面
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //用户查询
        User user=userService.queryUser(username,password);
        if(user!=null){
            System.out.println("恭喜你，" + user.getName() + "登录成功，即将跳转...");
            //添加session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("username",user.getName());
            request.getRequestDispatcher("WEB-INF/user/studentIndex.jsp").forward(request, response);
        }
        else {
            System.out.println("登陆失败，请检查用户名或密码是否正确");
            request.setAttribute("login_msg", "登陆失败，请检查用户名或密码是否正确");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

}
