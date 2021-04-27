package com.marvel.api.config;

import com.marvel.api.interception.FilterRequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfigure implements WebMvcConfigurer {
    @Autowired
    FilterRequestParam filterRequestParam;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(filterRequestParam);
    }
}
