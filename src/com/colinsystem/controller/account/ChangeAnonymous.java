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
 * 匿名状态切换
 * @author FrancisGaozhu
 * 2023-11-22 17:20:03
 */
@WebServlet(name = "changeAnonymous", urlPatterns = "/account/changeAnonymous")
public class ChangeAnonymous extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -3554590418281845643L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account loginUser = (Account) session.getAttribute("loginUser");
        if (!ACCOUNT_BIZ.changeDefaultAnonymous(loginUser)) {
            //修改失败
            resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode("匿名状态切换失败", "UTF-8"));
            return;
        }
        session.setAttribute("loginUser", loginUser);
        resp.sendRedirect(req.getContextPath() + "/topic/getAll");
    }
}
