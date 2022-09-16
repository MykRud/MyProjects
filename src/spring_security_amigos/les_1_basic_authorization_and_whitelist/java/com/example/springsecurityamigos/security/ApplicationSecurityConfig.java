package com.example.springsecurityamigos.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() // we want to authorize requests
                .antMatchers("/", "login", "/css/*", "/js/*").permitAll()
                .anyRequest()
                .authenticated() // any request must be authenticated, client must specify username and password
                .and()
                .httpBasic(); // use basic auth
    }
}
