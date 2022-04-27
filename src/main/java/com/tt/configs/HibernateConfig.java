/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.configs;

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

/**
 *
 * @author anhtu
 */
@Configuration
@PropertySource("classpath:databases.properties")
public class HibernateConfig {
    
    @Autowired
    private Environment environment;
    
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setPackagesToScan("com.tt.pojos");
        factory.setDataSource(dataSource());
        
        return factory;
    }
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource data = new DriverManagerDataSource();
        
        data.setDriverClassName(environment.getProperty("hibernate.connection.driverClass"));
        data.setUrl(environment.getProperty("hibernate.connection.url"));
        data.setUsername(environment.getProperty("hibernate.connection.username"));
        data.setPassword(environment.getProperty("hibernate.connection.password"));
        
        return data;
    }
    
    public Properties hibernateProperties(){
        Properties props = new Properties();
        props.setProperty(SHOW_SQL, environment.getProperty("hibernate.showSql"));
        props.setProperty(DIALECT, environment.getProperty("hibernate.dialect"));
        return props;
    }
}
