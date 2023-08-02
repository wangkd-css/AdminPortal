package com.rmc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RmcAuthenticationFailureHandler  implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper mapper;

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(mapper.writeValueAsString(exception.getMessage()));
        
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        response.setStatus(401);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", 401);
        if (exception instanceof LockedException) {
            map.put("msg", "账户被锁定，登录失败!");
        } else if (exception instanceof BadCredentialsException) {
            map.put("msg", "账户名或密码输入错误，登录失败!");
        } else if (exception instanceof DisabledException) {
            map.put("msg", "账户被禁用，登录失败!");
        } else if (exception instanceof AccountExpiredException) {
            map.put("msg", "账户已过期，登录失败!");
        } else if (exception instanceof CredentialsExpiredException) {
            map.put("msg", "密码已过期，登录失败!");
        } else {
            map.put("msg", "登录失败!");
        }
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
        
    }
}