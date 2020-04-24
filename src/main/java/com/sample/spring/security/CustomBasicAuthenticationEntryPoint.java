package com.sample.spring.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.sample.spring.constants.Constants;
/**
 * This class is used to handle unauthorized requests.
 * @author Santhoshkumar
 *
 */
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	/**
	 * This method is used to prompt the user to know that their credentials are not authorized to access the 
	 * corresponding api.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + authException.getMessage());
	}
	
	@Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(Constants.REALM_NAME);
        super.afterPropertiesSet();
    }
}
