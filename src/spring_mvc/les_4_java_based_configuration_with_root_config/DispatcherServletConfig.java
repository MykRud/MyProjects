package com.mike.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.mike.springmvc")
// or implement WebMvcConfigurer, which is better (released in Spring 5, because Java 8 introduced default
// methods in interface, so this interface is able to cover all WebMvcConfigurerAdapter class).
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {
}
