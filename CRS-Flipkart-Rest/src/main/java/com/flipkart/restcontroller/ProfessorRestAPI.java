package com.flipkart.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.validator.ProfessorValidator;

@Path("/professor")
public class ProfessorRestAPI {
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();
	@GET
	@Path("/getEnrolledStudents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnrolledStudent> viewEnrolledStudents(
			@NotNull
			@Email(message = "Invalid Professor ID: Not in email format")
			@QueryParam("profId") String profId) 	{
		System.out.println(profId);
		List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
		try
		{
			students=professorInterface.viewStudents(profId);
		}
		catch(Exception ex)
		{
			return null;
		}	
		return students;
	}
	
	@GET
	@Path("/getCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses(
			@NotNull
			@Email(message = "Invalid Professor ID: Not in email format")
			@QueryParam("profId") String profId) 	{
		
		List<Course> courses=new ArrayList<Course>();
		try
		{
			courses=professorInterface.getCourses(profId);	
		}
		catch(Exception ex)
		{
			return null;
		}
		return courses;
	}
	
	@POST
	@Path("/addGrade")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGrade(
			@NotNull
			@QueryParam("studentId") String studentId,
			
			@NotNull
			@QueryParam("courseCode") String courseId,
			
			@NotNull
			@Email(message = "Invalid Professor ID: Not in email format")
			@QueryParam("profId") String profId,
			
			@QueryParam("semester") int semester,
			
			@QueryParam("grade") String grade) {
		
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewStudents(profId);
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(profId);
			if(ProfessorValidator.isValidEntry(enrolledStudents, studentId,courseId,semester))
				professorInterface.addGrade(studentId, courseId, semester, grade);
			else
				return Response.status(500).entity("Grade Could not be added").build();
		}
		catch(Exception ex)
		{
			return Response.status(500).entity("Grade Could not be added").build();
		}
		return Response.status(200).entity( "Grade updated for student: "+studentId).build();
		
	}
}
