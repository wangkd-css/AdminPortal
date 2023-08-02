package com.rmc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class RmcWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private RmcAuthenticationProvider provider;  //注入我们自己的AuthenticationProvider
	
	@Autowired
    private RmcAuthenticationSucessHandler myAuthenticationSuccessHandler;
    @Autowired
    private RmcAuthenticationFailureHandler myAuthenticationFailHander;
	
    @Autowired
    private DataSource dataSource;   //是在application.properites

    @Autowired
    private RmcUserService userDetailsService;
    
    /**
     * 记住我功能的token存取器配置
     * @return
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
/*
    	CREATE TABLE persistent_logins (
    		    username VARCHAR(64) NOT NULL,
    		    series VARCHAR(64) NOT NULL,
    		    token VARCHAR(64) NOT NULL,
    		    last_used TIMESTAMP NOT NULL,
    		    PRIMARY KEY (series)
    		);
*/
    	JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
          tokenRepository.setDataSource(dataSource);
          return tokenRepository;
    }
    
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
//--------------------------------------------------------------------------
//             //用户认证处理                                                           //密码处理
//		auth.userDetailsService(aoccUserService).passwordEncoder(passwordEncoder());
//--------------------------------------------------------------------------
//      auth.inMemoryAuthentication()
//        .withUser("root").password("123").roles("ADMIN", "DBA")
//        .and()
//        .withUser("admin").password("123").roles("ADMIN", "USER")
//        .and()
//        .withUser("sang").password("123").roles("USER");
	}
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .formLogin().loginPage("/").loginProcessingUrl("/login")
        .successHandler(myAuthenticationSuccessHandler)
        .failureHandler(myAuthenticationFailHander)
        .permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
        .and()
        .authorizeRequests().antMatchers("/css/*")
        .permitAll()
        .and()
        .authorizeRequests().antMatchers("/fonts/*")
        .permitAll()
        .and()
        .rememberMe()
        .rememberMeParameter("remember-me").userDetailsService(userDetailsService)
        .tokenRepository(persistentTokenRepository())
        .tokenValiditySeconds(600)
        .and()
        .authorizeRequests().anyRequest().authenticated()
//        .authorizeRequests().anyRequest().access("@rbacService.hasPermission(request,authentication)")
        .and()
        .logout()                       //开启注销登陆
        .logoutUrl("/logout")           //注销登陆请求url
        .clearAuthentication(true)      //清除身份信息
        .invalidateHttpSession(true)     //session失效
        .addLogoutHandler(new LogoutHandler() {  //注销处理
            
            public void logout(HttpServletRequest req,
                               HttpServletResponse resp,
                               Authentication auth) {

            }
        })
        .logoutSuccessHandler(new LogoutSuccessHandler() {     //注销成功处理
            public void onLogoutSuccess(HttpServletRequest req,
                                        HttpServletResponse resp,
                                        Authentication auth)
                    throws IOException {
                resp.sendRedirect("/login");              //跳转到自定义登陆页面
            }
        })
        .and()
        .csrf().disable();        
    }
}
