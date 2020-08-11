package com.java.filter;

import com.java.database.UserDb;
import com.java.handler.SuccessHandler;
import com.java.userdetails.User;
import com.java.utils.JsonUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/login")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter initialized");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        User u1=JsonUtils.toObject(servletRequest.getReader(), User.class);
        for (User user1: UserDb.users()) {
            if (user1.getPassword().equals(u1.getPassword())){
             request.setAttribute("userData",u1);
                SuccessHandler.loginSuccess(servletRequest,servletResponse);
                filterChain.doFilter(servletRequest,servletResponse);
            }
//            else {
//                response.getWriter().write("====loginFailed");
//            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("filter destroied");
    }
}
