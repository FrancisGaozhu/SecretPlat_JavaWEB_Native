package com.colinsystem.controller.topic;

import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 删除帖子
 * @author FrancisGaozhu
 * 2023-11-21 15:39:00
 */
@WebServlet(name = "deleteTopic", urlPatterns = "/topic/delete")
public class DeleteTopic extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -2859572281176622187L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long topicId = Long.parseLong(req.getParameter("topicId"));
        String message = TOPIC_BIZ.deleteTopicById(topicId) ? "帖子和对应消息删除成功！" : "删除失败";
        resp.sendRedirect(req.getContextPath() + "/topic/getAll?alertMessage=" + URLEncoder.encode("帖子已删除！", "UTF-8"));
    }
}
