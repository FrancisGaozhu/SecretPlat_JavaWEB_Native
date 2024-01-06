package com.colinsystem.controller.topic;

import com.colinsystem.entity.Topic;
import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 加载详情信息
 * @author FrancisGaozhu
 * 2023-11-24 14:42:19
 */
@WebServlet(name = "loadDetails", urlPatterns = "/topic/loadDetails")
public class LoadDetails extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -7122207143792626242L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long topicId = Long.parseLong(req.getParameter("id"));
        Topic topic = TOPIC_BIZ.getById(topicId, true, true, true);
        req.setAttribute("topic", topic);
        req.getRequestDispatcher("/WEB-INF/topic_detail.jsp").forward(req, resp);
    }
}
