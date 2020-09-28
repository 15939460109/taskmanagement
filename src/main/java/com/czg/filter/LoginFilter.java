package com.czg.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    private static String[] ignores = new String[]{
        "/html/login.html"
    };

    //判断该静态资源是否放行
    private static boolean isIgnore(String requestName) {
        for (String ignore : ignores) {
            if (requestName.equals(ignore)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestName = ((HttpServletRequest) servletRequest).getRequestURI();
        String userId = "";
        //找寻userId的cookie
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userId")) {
                userId = cookie.getValue();
            }
        }
        //判断userId是否有值
        if ("".equals(userId) && !isIgnore(requestName)) {
            //重定向
            ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
        } else {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
