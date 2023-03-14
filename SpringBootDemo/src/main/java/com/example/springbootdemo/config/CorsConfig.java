package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域访问服务端提供跨域支持
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  // 所有接口
        .allowedOriginPatterns("*")  //支持跨域
        .allowedMethods(new String[]{"GET","POST"})  //支持方法
        .maxAge(3600);
    }
    
}
