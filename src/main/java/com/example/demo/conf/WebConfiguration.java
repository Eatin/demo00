package com.example.demo.conf;

import com.example.demo.conf.LoginhandleIntercepor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("jsp/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:./uploads/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//                静态资源 css js 已经做好了静态资源映射
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**", "/druid").
                excludePathPatterns("/main", "/detail/**", "/login", "/logincheck", "/static/**", "/uploads/**");
    }


}
