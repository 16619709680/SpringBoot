package com.jn.springboot.filter;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Order(1)//执行顺序，越小越先执行
@WebFilter(filterName = "MyFilter" , urlPatterns = "/jn")
public class MyFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("..............init................");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("..............doFilter................");


        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("..............destroy................");
    }
}
