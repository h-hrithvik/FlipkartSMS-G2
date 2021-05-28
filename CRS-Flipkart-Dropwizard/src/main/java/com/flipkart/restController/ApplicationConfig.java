/**
 * 
 */
package com.flipkart.restController;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author lenovo
 *
 */

/*
 * All the API's are configured in this APPLication Config class
 * */

public class ApplicationConfig extends ResourceConfig {
	
	public ApplicationConfig() {
		register(StudentRestAPI.class);
		register(ProfessorRestAPI.class);
		register(AdminRestAPI.class);
		register(UserRestAPI.class);
	}
	

}
