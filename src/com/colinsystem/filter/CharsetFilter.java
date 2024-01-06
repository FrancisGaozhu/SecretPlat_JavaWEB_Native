package com.colinsystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符集过滤器
 *
 * @author FrancisGaozhu
 * 2023-11-21 18:42:33
 */
@WebFilter(filterName = "charsetFilter", urlPatterns = "/*")
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf8");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
