package com.tt.configs;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tt.controller",
    "com.tt.repository",
    "com.tt.services"})
public class WebApplicationContextConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
     
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver (){
        
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }

    // get data from resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry.addResourceHandler("/css/**")
                   .addResourceLocations("/resources/css/");
           
           registry.addResourceHandler("/js/**")
                   .addResourceLocations("/resources/js/");
           
           // All folder inside Image folder
           registry.addResourceHandler("/img/**")
                   .addResourceLocations("/resources/img/");
           registry.addResourceHandler("/slide/**")
                   .addResourceLocations("/resources/img/slide/");
           registry.addResourceHandler("/team/**")
                   .addResourceLocations("/resources/img/team/");
           
            // All folder inside Vendor folder
           registry.addResourceHandler("/vendor/**")
                   .addResourceLocations("/resources/vendor/");
    }
    
    
    // get data from propertiesfile
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        
        source.setBasenames("message","contentVNVer");
        
        return source;
    }
    
    // Create send data file method
    @Bean 
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        
        resolver.setDefaultEncoding("UTF-8");
        
        return resolver;
    }
    
}
