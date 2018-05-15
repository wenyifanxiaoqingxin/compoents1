package com.compoent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;

/**
 * Created by fx on 2018/5/15.
 */
@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    public final static String SESSION_KEY ="user";
    public final static String SESSION_ROLE ="1";
    @Bean
    public SecurityInterceptor getSecurityInterceptor(){

        return  new SecurityInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getSecurityInterceptor());

        //排除配置
        registration.excludePathPatterns("/error");
        registration.excludePathPatterns("/login**");
        registration.excludePathPatterns("/compoent**");
        //拦截
        registration.addPathPatterns("/**");

        super.addInterceptors(registry);
    }

    private class  SecurityInterceptor extends HandlerInterceptorAdapter {


        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            HttpSession session = request.getSession();

            if(session.getAttribute(SESSION_KEY)!=null){

                return true;

            }
            String url ="/login";
            response.sendRedirect(url);
            return false;
        }
    }
}
