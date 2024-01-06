package com.colinsystem.controller.account;

import com.colinsystem.entity.Account;
import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 注册新账户
 * @author FrancisGaozhu
 * 2023-11-23 15:28:42
 */
@WebServlet(name = "registerAccount", urlPatterns = "/account/register")
public class Register extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -1323525517557798534L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account registerAccount = new Account();
        registerAccount.setAnonymous(false);
        registerAccount.setName(req.getParameter("userName"));
        registerAccount.setPassword(req.getParameter("userPassword"));
        registerAccount.setAnonymous(req.getParameter("anonymous").equals("on"));
        if (!ACCOUNT_BIZ.register(registerAccount)) {
            resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode("注册失败！", "UTF-8"));
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/login.jsp?alertMessage=" + URLEncoder.encode("注册成功！请在这里登录。", "UTF-8"));
    }
}
