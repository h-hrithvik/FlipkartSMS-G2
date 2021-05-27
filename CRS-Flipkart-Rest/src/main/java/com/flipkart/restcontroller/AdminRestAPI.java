/**
 * 
 */
package com.flipkart.restcontroller;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

/**
 * @author arya_
 *
 */
@Path("/admin")
public class AdminRestAPI {
	
	AdminInterface adminOperation = AdminOperation.getInstance();
	
	/**
	 * /admin/deleteCourse
	 * REST-services for dropping a course from catalog
	 * @param courseCode
	 * @return
	 */
	@PUT
	@Path("/deleteCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCourse(
			//@Size(min = 1 , max = 10 , message = "Course Code length should be between 4 and 10 character")
			@NotNull
			@QueryParam("courseId") String courseCode) throws ValidationException{
		
		try {
			adminOperation.removeCourse(courseCode);
			return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
		
	}
	
	/**
	 * /admin/addCourse
	 * REST-service for adding a new course in catalog
	 * @param course
	 * @return
	 */
	@POST
	@Path("/addCourse")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(@Valid Course course) throws ValidationException{

		try {
			adminOperation.addCourse(course);
			return Response.status(201).entity("Course with courseId: " + course.getCourseId() + " added to catalog").build();
		} catch (AddCourseException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
			
	}
	
	/**
	 * /admin/approveStudent
	 * REST-service for approving the student admission
	 * @param studentId
	 * @return
	 */
	@PUT
	@Path("/approveStudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Response approveStudent(
			@NotNull
			@QueryParam("studentId") String studentId) throws ValidationException{
		try {
			adminOperation.approveStudent(studentId);
			return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();
	
		} catch (StudentNotFoundForVerificationException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}		
	}
	
	/**
	 * /admin/addProfessor
	 * REST-service for addding a new professor
	 * @param professor
	 * @return
	 */
	@POST
	@Path("/addProfessor")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(@Valid Professor professor) throws ValidationException{
		 
		try {
			adminOperation.addProfessor(professor);
			return Response.status(201).entity("Professor with professorId: " + professor.getUserId() + " added").build();
		} catch (ProfessorNotAddedException | UserAlreadyExistException e) {
			return Response.status(409).entity(e.getMessage()).build();
		}
				
	}

}
