package com.sample.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.sample.spring.constants.Constants;

/**
 * This class is to create spring security servlet filter which is responsible for all security related actions within this application.
 * @author Santhoshkumar
 *
 */
@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * This method is to create user with crentials and map it to a role.
	 * Used {noop} before adding password to enable NoOpPasswordEncoder for plain text passwords
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("bill").password("{noop}abc123").roles(Constants.PRODUCT_MGMT_ROLE);
        auth.inMemoryAuthentication().withUser("tom").password("{noop}abc123").roles(Constants.CONFIGURATION_MGMT_ROLE);
    }
	
	/**
	 * This method is to configure web based security for all HTTP Requests.
	 * Here we have authorized users with product management role to access product details api and users with configuration management role
	 * to access configuration details api.
	 * If any unauthorized request trying to access, CustomBasicAuthenticationEntryPoint class will be invoked.
	 * For 403 forbidden exception, CustomAccessDeniedHandler class will be invoked.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
        	.authorizeRequests()
        	.antMatchers(Constants.API_COMMON_PATH + Constants.API_PRODUCT_DETAILS_PATH).hasRole(Constants.PRODUCT_MGMT_ROLE)
        	.antMatchers(Constants.API_COMMON_PATH + Constants.API_CONFIG_DETAILS_PATH).hasRole(Constants.CONFIGURATION_MGMT_ROLE)
        	.and().httpBasic().authenticationEntryPoint(getBasicAuthEntryPoint())
        	.and().exceptionHandling().accessDeniedHandler(getCustomAccessDeniedHandler())
        	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }
	
	@Bean
    public CustomAccessDeniedHandler getCustomAccessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
