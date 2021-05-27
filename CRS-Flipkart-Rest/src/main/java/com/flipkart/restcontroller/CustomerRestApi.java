/**
 * 
 */
package com.flipkart.restcontroller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipkart.bean.Customer;

/**
 * @author lenovo
 *
 */
@Path("/customer")
public class CustomerRestApi {
	
	@GET
	@Path("/customerdetails")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer() {
		// All the service class here which will return the java object , convert into in json.
		Customer customer = new Customer();
		customer.setCustid(1);
		customer.setCustName("Shubham");
		customer.setCustAddress("Pune");
		
	   return customer;

	}

}
