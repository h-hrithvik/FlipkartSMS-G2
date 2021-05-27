/**
 * 
 */
package com.flipkart.restController;
import static com.flipkart.constant.RoleConstants.STUDENT;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import com.flipkart.bean.Student;
import com.flipkart.constant.RoleConstants;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

/**
 * @author JEDI-02
 *
 */

@Path("/user")
public class UserRestAPI {

	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	
	/**
	 * 
	 * @param userId
	 * @param password
	 * @return 
	 */
	
	@POST
	@Path("/login")
	public Response loginUser(
			@NotNull
			@Email(message = "Invalid User ID: Not in email format")
			@QueryParam("userId") String userId,
			@NotNull
			@Size(min = 1, max = 20 , message = "Password length should be between 1 and 20 characters")
			@QueryParam("password") String password) throws ValidationException {
		try {
			
			UserInterface userInterface = new UserOperation();
			boolean loggedin = userInterface.verifyCredentials(userId, password);
			// 2 cases
			// true->role->student->approved
			if (loggedin) {
				String role = userInterface.getRole(userId);
//				Role userRole = Role.(role);
				RoleConstants userRole = RoleConstants.stringToName(role);
				switch (userRole) {
				case ADMIN:
					return Response.status(200).entity("Login successful ").build();
					
				case PROFESSOR:
					return Response.status(200).entity("Login successful").build();
					
				case STUDENT:
					StudentInterface studentInterface = new StudentOperation();
					int isApproved=0;
					try {
						isApproved = studentInterface.checkIsVerified(userId);
					} catch (StudentNotRegisteredException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (isApproved == 1) {
						return Response.status(200).entity("Login successful").build();

					} else {
						loggedin = false;
						return Response.status(200).entity("You have not been approved by the admin!").build();
						
					}
				}

			} else {
				return Response.status(500).entity("Invalid credentials!").build();
			}

		} catch (UserNotFoundException ex) {
			return Response.status(500).entity(ex.getMessage()).build();
		}
		return null;
		
		
}
	
	
	/**
	 * 
	 * @param student
	 * @return 201, if user is created, else 500 in case of error
	 */
	@POST
	@Path("/studentRegistration")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerStudent(@Valid Student student)
	{
		
		try
		{
			StudentOperation studentOperation = new StudentOperation();
			studentOperation.registerStudent(student.getUserName(), student.getPhoneNumber(), student.getAddress(), student.getUserId(), student.getUserPassword(), String.valueOf(STUDENT),
					student.getRollNumber(), student.getBranch(), false);
		}
		catch(Exception ex)
		{
			return Response.status(500).entity("Something went wrong! Please try again.").build(); 
		}
		
		
		return Response.status(201).entity("Registration Successful for "+student.getUserId()).build(); 
	}
	
}
