package com.sample.spring.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.sample.spring.constants.Constants;
/**
 * This class is used to handle forbidden requests.
 * 
 * @author Santhoshkumar
 *
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.addHeader("WWW-Authenticate", "Basic realm=" + Constants.REALM_NAME + "");
         
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 403 : " + accessDeniedException.getMessage());
	}

}
