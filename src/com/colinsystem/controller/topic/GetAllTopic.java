package com.colinsystem.controller.topic;

import com.colinsystem.util.Bizs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author FrancisGaozhu
 * 2023-11-21 15:34:21
 */
@WebServlet(name = "getAllTopic", urlPatterns = "/topic/getAll")
public class GetAllTopic extends HttpServlet implements Bizs {
    private static final long serialVersionUID = -631517446899054956L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allTopics", TOPIC_BIZ.getAll(true, false));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
