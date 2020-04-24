package com.sample.spring.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.sample.spring.security.AppSecurityConfiguration;

/**
 * 
 * @author Santhoshkumar
 *
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 @Override
	 protected Class < ? > [] getServletConfigClasses() {
		 return new Class[] { 
			  ApplicationConfiguration.class
	  	 };
	 }
	 
	 @Override
	 protected Class < ? > [] getRootConfigClasses() {
		 return new Class[] {
				 AppSecurityConfiguration.class
		};
	 }
	 
	 @Override
	 protected String[] getServletMappings() {
		  return new String[] {
		   "/"
		  };
	 }
}

