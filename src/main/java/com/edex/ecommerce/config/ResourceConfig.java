package com.edex.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String uploadLocation = "/home/kernelogy/learn/spring/ecommerce/src/main/resources/uploads/";
        registry
        .addResourceHandler("/uploads/**")
        .addResourceLocations("file:" + uploadLocation);
    }
    
}
