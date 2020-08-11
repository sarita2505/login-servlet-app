package com.java.filter;

import com.java.database.UserDb;
import com.java.userdetails.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class TokenValidationFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(TokenValidationFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("tvf filter executed");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String s1 = request.getHeader("Authorization");
        if (s1 != null && s1.length()>0) {
            String pass = s1.substring(0, 5);
            LOGGER.info(pass);
            for (User user : UserDb.users()) {
                if (user.getPassword().equals(pass)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
        }else{
            response.setStatus(403);
            response.getWriter().write("wrong header");
        }

    }

    @Override
    public void destroy() {

    }
}
