/**
 * 
 */
package com.flipkart.restcontroller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

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
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Customer customer) {
        System.out.println("hit post service");
        
        System.out.println("value of ID from UI " +customer.getCustid());
        System.out.println("value of Name form UI" +customer.getCustName());
        System.out.println("value of Address form UI" +customer.getCustAddress());

        
        String result = "Track saved : " + customer;
		
		
		return Response.status(201).entity(result).build();
		
	}  

	@DELETE
	@Path("/delete/{custId}")
	public Response deleteTrackInJSON(@PathParam("custId") int custId)
	throws URIReferenceException{
		/*
		 * Call the service methods to call the operations
		 * */
		// implementation
		return Response.status(200).entity("Customer id " +custId +
				"successfully deleted").build();
	}
	

	@PUT
	@Path("/update")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer updateTrackInJson(Customer customer){
		
		customer.setCustAddress(customer.getCustAddress() +"updated");
		return customer;
		
	}
	
}
