package com.java.handler;

import com.java.userdetails.User;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class SuccessHandler {
    private final static Logger LOGGER = Logger.getLogger(SuccessHandler.class.getName());
    public static void loginSuccess(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = new User();
        if (user instanceof Object==true) {
            user = (User) request.getAttribute("userData");
        }
        String token=user.getPassword()+ UUID.randomUUID();
        LOGGER.info(token);
        response.setHeader("Authorization",token);
        response.getWriter().write(token);
    }
}
