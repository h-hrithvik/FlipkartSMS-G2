/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;

import com.flipkart.service.AdminOperation;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.service.AdminInterface;
/**
 * @author arya_
 *
 */
public class AdminClient {
	
	AdminInterface adminObj =new AdminOperation();
	Scanner scanner = new Scanner(System.in);

	public void createMenu(){		
		
		int in=0;
		while(in!=5) {
			
			System.out.println("ADMIN MENU");
			System.out.println("1. Add Course to catalog");
			System.out.println("2. Delete Course from catalog");
			System.out.println("3. Approve Students");
			System.out.println("4. Add Professor");
			System.out.println("5. Generate Report Card");
			System.out.println("6. Remove Professor");
			System.out.println("7. Exit Admin Menu");
			in=scanner.nextInt();
				
			switch(in) {
			case 1:
				addCourse();
				break;
					
			case 2:
				deleteCourse();
				break;
					
			case 3:
				approveStudent();
				break;
					
			case 4:
				addProfessor();
				break;
			
			case 5:
				generateReport();
				break;
				
			case 6:
				removeProfessor();
				break;
				
			case 7:
				returnToLogin();
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	private void addCourse()
	{
		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();
		
		System.out.println("Enter Course Name:");
		String courseName = scanner.next();
		
		System.out.println("Enter InstructorId:");
		String instructorId = scanner.next();
				
		Course course = new Course(courseCode, courseName, instructorId, 10);
		
		try {
			adminObj.addCourse(course);
		} catch (AddCourseException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	private void deleteCourse()
	{
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		
		try {
			adminObj.removeCourse(courseCode);
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private boolean approveStudent()
	{	
		System.out.println("Enter Student's ID:");
		String studentUserIdApproval = scanner.nextLine();
		
		try {
			adminObj.approveStudent(studentUserIdApproval);
			return true;
	
		} catch (StudentNotFoundForVerificationException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	private void addProfessor()
	{
		System.out.println("Enter Professor Name:");
		String professorName = scanner.next();
		
		System.out.println("Enter Department:");
		String department = scanner.next();
		
		System.out.println("Enter Phone:");
		String phoneNo = scanner.next();
		
		System.out.println("Enter User Id:");
		String userId = scanner.next();
		
		System.out.println("Enter Password:");
		String password = scanner.next();
		
		System.out.println("Enter Address:");
		String address = scanner.next();
				
		Professor professor = new Professor(professorName,phoneNo,address,userId,password,"Professor");
		try {
			adminObj.addProfessor(professor);
		} catch (ProfessorNotAddedException | UserAlreadyExistException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void removeProfessor() throws ProfessorNotAddedException
	{
		System.out.println("Enter Professor Code:");
		String professorId = scanner.next();
		
		try {
			adminObj.removeProfessor(professorId);
		} catch (ProfessorNotAddedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void returnToLogin()
	{
		
	}
	private void generateReport()
	{
		
	}
}
