/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import static org.hibernate.cfg.Environment.*;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

/**
 *
 * @author hp
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {
    @Autowired
    private Environment enve;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        
        factory.setPackagesToScan("com.findingcareer.pojo");
        factory.setDataSource(dataSource());
        factory.setHibernateProperties(hibernateProperties());
        
        return factory;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource data = new DriverManagerDataSource();
        
        data.setDriverClassName(enve.getProperty("hibernate.connection.driverClass"));
        data.setUrl(enve.getProperty("hibernate.connection.url"));
        data.setUsername(enve.getProperty("hibernate.connection.username"));
        data.setPassword(enve.getProperty("hibernate.connection.password"));
        
        return data;
    } 
    public Properties hibernateProperties(){
        Properties property = new Properties();
        
        property.setProperty(SHOW_SQL, enve.getProperty("hibernate.showSql"));
        property.setProperty(DIALECT, enve.getProperty("hibernate.dialect"));
        
        return property;
    }
    @Bean 
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        
        transactionManager.setSessionFactory(getSessionFactory().getObject());
     
        return transactionManager;
    }
    //Using cloudinary to upload file 
    @Bean
    public Cloudinary cloudinary(){
        Cloudinary c = new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dd58hrv0h",
                "api_key","388372944622867",
                "api_secret","-lyQci3ZQYQcLOi168TI4V8kU7g",
                "secure",true
                ));
        
        return c;
    }
}
