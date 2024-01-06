package com.colinsystem.controller.message;

import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 删除留言
 * @author FrancisGaozhu
 * 2023-11-24 20:12:50
 */
@WebServlet(name = "deleteMessage", urlPatterns = "/message/delete")
public class DeleteMessage extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -7474006022653391598L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long messageId = Long.parseLong(req.getParameter("messageId"));
        long topicId = Long.parseLong(req.getParameter("topicId"));
        String alertMessage = MESSAGE_BIZ.deleteMessage(messageId) ? "跟帖删除成功！" : "删除失败！";
        resp.sendRedirect(req.getContextPath() + "/topic/loadDetails?id=" + topicId + "&alertMessage=" + URLEncoder.encode(alertMessage, "UTF-8"));
    }
}
