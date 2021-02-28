package com.cy.web;

import com.cy.pojo.User;
import com.cy.service.UserService;
import com.cy.service.impl.UserServiceImpl;
import com.cy.test.UserServletTest;
import com.cy.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 username
        String username = req.getParameter("username");
        //调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装称为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);
    }
    /*
    * 注销
    * */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 销毁session中用户的信息(或者销毁session)
        req.getSession().invalidate();
        //2 重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1  获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2 调用UserService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        //判断登录是否成功
        if (loginUser==null){
            //如果等于null 说明登录失败  跳回登录页面
            //把错误信息，和回显的表单项信息，保存到request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //保存用户登录的信息到session域中
            req.getSession().setAttribute("user",loginUser);
            //登录成功   跳到login_success.html页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String  token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //1 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

       /* User user = new User();
        WebUtils.copyParamToBean(req.getParameterMap(),user);*/
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());


        //2 检查验证码是否正确  === 写死  要求验证码为abcde
        if (token!=null && token.equalsIgnoreCase(code)){
            //正确
            //检查 用户名是否正确
            if (userService.existsUsername(username)){
                //不可用  跳回注册页面
                System.out.println("用户名["+username+"]不可用!");

                //把回显信息保存到request域中
                req.setAttribute("msg","用户名已存在!!");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                //可用
                userService.registUser(new User(null,username,password,email));
                //调转到注册成功页面。
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //把回显信息保存到request域中
            req.setAttribute("msg","验证码错误!");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            //不正确 跳回注册页面
            System.out.println("验证码["+code+"]错误！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


}
