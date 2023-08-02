package com.rmc;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

@Component("rbacService")
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
          Object principal = authentication.getPrincipal();
          boolean hasPermission = false;
          if (principal instanceof UserDetails) { //首先判断先当前用户是否是我们UserDetails对象。
                String userName = ((UserDetails) principal).getUsername();
                HashSet<String> urls = new HashSet<String>(); // 数据库读取 //读取用户所拥有权限的所有URL
                
                urls.add("/whoim");
                // 注意这里不能用equal来判断，因为有些URL是有参数的，所以要用AntPathMatcher来比较
                for (String url : urls) {
                      if (antPathMatcher.match(url, request.getRequestURI())) {
                            hasPermission = true;
                            break;
                      }
                }
          }
          return hasPermission;
    }
}
