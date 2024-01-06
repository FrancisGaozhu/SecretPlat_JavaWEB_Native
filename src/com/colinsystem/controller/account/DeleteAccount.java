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
 * 永久删除账户
 * @author FrancisGaozhu
 * 2023-11-23 15:27:58
 */
@WebServlet(name = "deleteAccount", urlPatterns = "/account/delete")
public class DeleteAccount extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -7256687373117532229L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account currentAccount = (Account) session.getAttribute("loginUser");
        //删除失败
        boolean deleteResult = ACCOUNT_BIZ.deleteAccountById(currentAccount.getId());
        if (deleteResult)
            session.removeAttribute("loginUser");
        String message = deleteResult? "账户信息删除成功！" : "账户信息删除失败";
        resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode(message, "UTF-8"));
    }
}
