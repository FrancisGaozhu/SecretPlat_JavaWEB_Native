package com.colinsystem.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 字符集过滤器
 *
 * 因为过滤器是在控制器之前拦截执行，所以即便在特别的情况下需要对于响应设置不同的ContentType，也可以在
 * 对应的控制器中做单独的设置，不需要更改这里的代码。
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
