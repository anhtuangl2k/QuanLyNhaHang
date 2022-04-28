 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author hp
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.tt.repository",
    "com.tt.services"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//    @Autowired
//    private UserDetailsService userDetailsService;
//  
    // Method help encoder passwork
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).
//                passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").usernameParameter("username")
                .passwordParameter("password");
        // Login 
        http.formLogin().defaultSuccessUrl("/").failureUrl("/login?error");
        // Logout
        http.logout().logoutSuccessUrl("/login");
        //Dont accept access from unknow account
        http.exceptionHandling().accessDeniedPage("/login?accessDenied");
        // Access permissions 
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user/**")
//                .access("hasRole('ROLE_USER')")
//                .antMatchers("/employer/**")
//                .access("hasRole('ROLE_EMPLOYER')")
//                .antMatchers("/employee/**")
//                .access("hasRole('ROLE_EMPLOYEE')")
//                .antMatchers("/recruitment/**")
//                .access("hasAnyRole('ROLE_EMPLOYEE','ROLE_EMPLOYER','ROLE_ADMIN')");
        
        http.csrf().disable();
    }
    
    
}
