package com.colinsystem.controller.account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 执行安全退出（注销登陆）操作
 * @author FrancisGaozhu
 * 2023-11-21 15:48:48
 */
@WebServlet(name = "logout", urlPatterns = "/account/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 3442439391271519619L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("loginUser");
        resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode("您已经退出登录！", "UTF-8"));
    }
}
