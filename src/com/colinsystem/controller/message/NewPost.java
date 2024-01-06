package com.colinsystem.controller.message;

import com.colinsystem.entity.Account;
import com.colinsystem.entity.Message;
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
 * 发布新的跟帖信息
 * @author FrancisGaozhu
 * 2023-11-24 20:35:09
 */
@WebServlet(name = "newPostMessage", urlPatterns = "/message/newPost")
public class NewPost extends HttpServlet implements Bizs {
    private static final long serialVersionUID = 8447266893441037635L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account loginUser = (Account) session.getAttribute("loginUser");
        long topicId = Long.parseLong(req.getParameter("topicId"));
        String messageContent = req.getParameter("messageContent");
        Message newMessage = new Message();
        newMessage.setAccountId(loginUser.getId());
        newMessage.setContent(messageContent);
        newMessage.setTopicId(topicId);
        newMessage.setCreateTime(LocalDateTime.now());
        String alertMessage = MESSAGE_BIZ.newPost(newMessage) ? "跟帖发布成功！" : "跟帖发布失败！";
        resp.sendRedirect(req.getContextPath() + "/topic/loadDetails?id=" + topicId + "&alertMessage=" + URLEncoder.encode(alertMessage, "UTF-8"));
    }
}
