package com.colinsystem.controller.account;

import com.colinsystem.entity.Account;
import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 账户登录
 * @author FrancisGaozhu
 * 2023-11-22 16:04:52
 */
@WebServlet(name = "login", urlPatterns = "/account/login")
public class Login extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -7009920568533390986L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Account loginUser = ACCOUNT_BIZ.login(name, password);
        if (loginUser == null) {
            //登录失败
            resp.sendRedirect(req.getContextPath() + "/login.jsp?alertMessage=" + URLEncoder.encode("登录失败", "UTF-8"));
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("loginUser", loginUser);
        resp.sendRedirect(req.getContextPath() + "/topic/getAll");
    }
}
