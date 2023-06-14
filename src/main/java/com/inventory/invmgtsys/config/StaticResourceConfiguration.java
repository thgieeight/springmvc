package com.inventory.invmgtsys.config;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)

public class StaticResourceConfiguration implements WebMvcConfigurer {


    @Override

    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String myExternalFilePath = "file:\\D:\\invmgtsys\\src\\main\\uploads\\";

        registry.addResourceHandler("/uploads/**").addResourceLocations(myExternalFilePath);



    }



}