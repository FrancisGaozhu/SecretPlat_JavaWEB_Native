package com.colinsystem.controller.topic;

import com.colinsystem.entity.Account;
import com.colinsystem.entity.Topic;
import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * 发布新帖子
 * @author FrancisGaozhu
 * 2023-11-24 16:14:58
 */
@WebServlet(name = "newPostTopic", urlPatterns = "/topic/newPost")
public class NewPost extends HttpServlet implements Bizs {
    private static final long serialVersionUID = 8136195964650188799L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account loginUser = (Account) session.getAttribute("loginUser");
        Topic newTopic = new Topic();
        newTopic.setTitle(req.getParameter("title"));
        newTopic.setContent(req.getParameter("content"));
        newTopic.setAccountId(loginUser.getId());
        newTopic.setCreateTime(LocalDateTime.now());
        String message = TOPIC_BIZ.addNew(newTopic) ? "新帖已经发布！" : "发帖失败";
        resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode(message, "UTF-8"));
    }
}
