/**
 * 
 */
package com.flipkart.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorOperation;
import com.flipkart.validator.ProfessorValidator;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;

/**
 * @author hp
 *
 */
public class ProfessorMenuCRS {
	ProfessorInterface professorobj=new ProfessorOperation();
	public void professorMenu(String professorId)
	{
		Scanner sc=new Scanner(System.in);
		
		int in=1;
		while(in!=4)
		{
			System.out.println("------------------------------------------");
			System.out.println("              PROFESSOR MENU              ");
			System.out.println("------------------------------------------");

			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Logout");

			System.out.println("------------------------------------------");
			System.out.println("  ENTER YOUR CHOICE");
			System.out.println();

			in=sc.nextInt();
			//input user
			
			switch(in)
			{
				case 1:
					//view all the courses taught by the professor
					getCourses(professorId);
					break;
				case 2:
					//view all the enrolled students for the course
					viewStudents(professorId);
					break;
					
				case 3:
					//add grade for a student
					addGrade(professorId);
					break;
				case 4:
					//logout from the system
					return;
				default:
					System.out.println("Select right option.");
			}
			
		}
		sc.close();
		
		
	}

	private void addGrade(String professorId){
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		String studentId;
		String courseId;
		String grade;
		int semester;
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorobj.viewStudents(professorId);
			System.out.println("-----------------------------------------------------------------------------------------");
			for(EnrolledStudent obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId(),obj.getSemester()));
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorobj.getCourses(professorId);
			System.out.println("----------------Add Grade--------------");
			System.out.println("Enter student Id");
			studentId=sc.nextLine();
			System.out.println("Enter course Id");
			courseId=sc.nextLine();
			System.out.println("Enter grade");
			grade=sc.nextLine();
			System.out.println("Enter semester");
			semester=sc.nextInt();
			sc.nextLine();
			if(ProfessorValidator.isValidEntry(enrolledStudents, studentId,courseId,semester))
			{
				try {
				professorobj.addGrade(studentId, courseId, semester,grade);
				System.out.println("Grade added successfully for "+studentId);
				}
				catch(Exception e)
				{
					System.out.println("Something went wrong "+e.getMessage());
				}
			}
			else
			{
				System.out.println("Invalid data entered, try again!");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
		
	}

	private void viewStudents(String professorId) {

		System.out.println(String.format("%20s %20s %20s %20s","COURSE ID","COURSE NAME","STUDENTS ID","SEMESTER" ));

		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorobj.viewStudents(professorId);
			System.out.println("-----------------------------------------------------------------------------------------");
			for(EnrolledStudent obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getStudentId(),obj.getSemester()));
			}
			System.out.println("-----------------------------------------------------------------------------------------");
		}

		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}

	private void getCourses(String professorId) {

		try
		{
			List<Course> coursesEnrolled=professorobj.getCourses(professorId);
			System.out.println(String.format("%20s %20s %20s","COURSE ID","COURSE NAME","STUDENTS REGISTERED" ));
			System.out.println("-----------------------------------------------------------------------------------------");
			for(Course obj: coursesEnrolled)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),10- obj.getSeats()));
			}
			System.out.println("-----------------------------------------------------------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println("Something went wrong!"+ex.getMessage());
		}
	}
}
