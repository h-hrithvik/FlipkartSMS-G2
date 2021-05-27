/**
 *
 */
package com.flipkart.restcontroller;

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
		register(CustomerRestApi.class);
		register(ProfessorRestAPI.class);
	}


}
