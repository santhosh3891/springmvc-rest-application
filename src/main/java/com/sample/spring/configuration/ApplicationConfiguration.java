package com.sample.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Main configuration class for this application. Enables spring to load all the classes specified in the basePackages.
 * 
 * @author Santhoshkumar
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sample.spring.controller", "com.sample.spring.model", "com.sample.spring.security"})
public class ApplicationConfiguration {

}

