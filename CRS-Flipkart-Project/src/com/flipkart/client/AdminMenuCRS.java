
package com.flipkart.client;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.flipkart.service.AdminOperation;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.exception.AddCourseException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.ProfessorNotDeletedException;
import com.flipkart.exception.StudentNotFoundForVerificationException;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.service.AdminInterface;

/**
 *
 * @author JEDI-03
 * Class that display Admin Client Menu
 *
 */


public class AdminMenuCRS {

	private static Logger logger = Logger.getLogger(AdminMenuCRS.class);

	AdminInterface adminOperation =AdminOperation.getInstance();
	Scanner scanner = new Scanner(System.in);

	public void createMenu(){		
		
		int in=0;
		while(in!=7) {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------ADMIN MENU---------------------------------------");
			System.out.println("---------------------------------------------------------------------------------------------\n");

			System.out.println("1. Add Course to catalog");
			System.out.println("2. Delete Course from catalog");
			System.out.println("3. Approve Students");
			System.out.println("4. Add Professor");
			System.out.println("5. Generate Report Card");
			System.out.println("6. Remove Professor");
			System.out.println("7. Exit Admin Menu");

			System.out.println("------------------------------------------");
			System.out.print("ENTER YOUR CHOICE--->:\t");


			in=scanner.nextInt();
			scanner.nextLine();
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
				return;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
	}

	/**
	 * Method to add course to DB
	 */
	private void addCourse()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------ADD COURSE TO CATALOG--------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();
		
		System.out.println("Enter Course Name:");
		String courseName = scanner.nextLine();
		
		System.out.println("Enter InstructorId:");
		String instructorId = scanner.nextLine();
				
		Course course = new Course(courseCode, courseName, instructorId, 10);
		
		try {
			adminOperation.addCourse(course);
		} catch (AddCourseException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}


	/**
	 * Method to delete course from DB
	 */
	private void deleteCourse()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------DELETE COURSE FROM CATALOG--------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		
		try {
			adminOperation.removeCourse(courseCode);
		} catch (CourseNotFoundException | CourseNotDeletedException e) {
			logger.error(e.getMessage());
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}


	/**
	 * Method to approve studentId
	 */
	private boolean approveStudent()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------APPROVE STUDENT--------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Student's ID:");
		String studentUserIdApproval = scanner.nextLine();
		
		try {
			adminOperation.approveStudent(studentUserIdApproval);
			return true;
	
		} catch (StudentNotFoundForVerificationException e) {
			logger.error(e.getMessage());
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

		return false;
	}


	/**
	 * Method to add Professor from DB
	 */
	private void addProfessor()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------ADD PROFESOR----------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Professor Name:");
		String professorName = scanner.next();

		System.out.println("Enter Phone:");
		String phoneNo = scanner.next();
		
		System.out.println("Enter User Id:");
		String userId = scanner.next();
		
		System.out.println("Enter Password:");
		String password = scanner.next();
		
		System.out.println("Enter Address:");
		String address = scanner.next();

		System.out.println("Enter Professor Id:");
		String professorId = scanner.next();

		System.out.println("Enter Department:");
		String department = scanner.next();

		Professor professor = new Professor(professorName,phoneNo,address,userId,password,"Professor",professorId,department);
		try {
			adminOperation.addProfessor(professor);
		} catch (ProfessorNotAddedException | UserAlreadyExistException e) {
			logger.error(e.getMessage());
		}

		System.out.println("---------------------------------------------------------------------------------------------\n");

	}


	/**
	 * Method to delete Professor from DB
	 */	
	private void removeProfessor() 
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------REMOVE PROFESOR----------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter Professor Code:");
		String professorId = scanner.next();
		
		try {
			adminOperation.removeProfessor(professorId);
		} catch (ProfessorNotAddedException | ProfessorNotDeletedException e) {
			logger.error(e.getMessage());
		}
	}


	/**
	 * Function to generate report
	 */
	private void generateReport()
	{
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------GENERATE PROFESOR----------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");

		System.out.println("Enter student Id:");
		String studentId = scanner.nextLine();
		
		System.out.println("Enter student Semester:");
		int studentSem = scanner.nextInt();						
		try {
			adminOperation.generateReport(studentId,studentSem);
		} catch (StudentNotRegisteredException e) {
			logger.error(e.getMessage());
		}
		System.out.println("---------------------------------------------------------------------------------------------\n");

	}
}
