package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package com.app.config
 * @ClassName WebMvcConfig
 * @Author shaobin.wang
 * @Date 2019/05/27 9:38
 * @Version 1.0
 * @Description:
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    //设置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }
}
