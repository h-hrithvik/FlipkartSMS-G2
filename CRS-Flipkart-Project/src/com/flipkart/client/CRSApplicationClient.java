
package com.flipkart.client;

import java.util.Scanner;

import javax.management.relation.Role;
import org.apache.log4j.Logger;
import com.flipkart.constant.RoleConstants;
import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.StudentInterface;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

import static com.flipkart.constant.RoleConstants.STUDENT;



/*
 * The class displays the menu
 *  for CRS project
 *
 */
 
public class CRSApplicationClient {

	/*
	 * Getting all reqiured objects for all the operations
	 * 
	 * */
	private static Logger logger = Logger.getLogger(CRSApplicationClient.class);
	static boolean loggedin = false;
	UserInterface userInterface =UserOperation.getInstance();

	
	/*
	 * Main Menu of the project
	 * 
	 * */
	public static void main(String[] args) throws StudentNotRegisteredException {
		Scanner sc = new Scanner(System.in);
		boolean logge2dIn = false;
		System.out.println("================================================================================");
		System.out.println("********************WELCOME to Course Registration System!!!********************");
		System.out.println("================================================================================");

		printMenu();
		String Input=sc.nextLine();
		
		while(Input!="3")
		{
			switch(Input)
			{	
				case "1":
					registerStudent();
					break;
				case "2":
					loginUser();
					break;
				case "3":
					break;
				default:
					System.out.println("Enter a valid input");
			}
			printMenu();
			Input = sc.nextLine();
		}
		System.out.println("*******************************Thank you for using our Application.*********************************");
		sc.close();
	}

	
	public static void printMenu() {
		System.out.println("\n\n----------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------MAIN MENU-----------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------\n");

		System.out.println("1. Signup");
		System.out.println("2. Login ");
		System.out.println("3. Exit");
		System.out.println("------------------------------------------");
		System.out.print("ENTER YOUR CHOICE----->:\t");

	}
	
	/*
	 *Student signup function 
	 * 
	 * */
	private static void registerStudent() {
		Scanner sc = new Scanner(System.in);

		String userId, name, password, address, branch, mobileNumber, rollNumber;

		try {
			// input all the student details
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------STUDENT SIGN UP------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------\n");

			System.out.println("Name:");
			name = sc.nextLine();
			System.out.println("Roll Number:");
			rollNumber = sc.nextLine();
			System.out.println("Email:");
			userId = sc.nextLine();
			System.out.println("Password:");
			password = sc.nextLine();
			System.out.println("Mobile Number:");
			mobileNumber = sc.nextLine();
			System.out.println("Branch:");
			branch = sc.nextLine();
			System.out.println("Address:");
			address = sc.nextLine();

			StudentOperation studentOperation = new StudentOperation();
			studentOperation.registerStudent(name, mobileNumber, address, userId, password, String.valueOf(STUDENT),
					rollNumber, branch, false);
			System.out.println("-----------------------------------------------------------------------------------------\n");

		} catch (UserAlreadyExistException ex) {
			ex.getMessage();
		}
	}

	/*
	 *Student Login after signup 
	 * 
	 * */
	private static void loginUser() throws StudentNotRegisteredException {
		Scanner sc = new Scanner(System.in);

		String userId, password;
		try {
			System.out.println("\n\n----------------------------------------------------------------------------------------");
			System.out.println("---------------------------------------------LOGIN----------------------------------------");
			System.out.println("-----------------------------------------------------------------------------------------\n");

			System.out.println("Email:");
			userId = sc.next();
			System.out.println("Password:");
			password = sc.next();
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
					System.out.println(" Login Successful!");
					AdminMenuCRS adminMenu = new AdminMenuCRS();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					System.out.println(" Login Successful!");
					ProfessorMenuCRS professorMenu = new ProfessorMenuCRS();
					professorMenu.professorMenu(userId);

					break;
				case STUDENT:
					StudentInterface studentInterface = new StudentOperation();
					int isApproved = studentInterface.checkIsVerified(userId);
					if (isApproved == 1) {
						System.out.println( " Login Successful!");
						StudentMenuCRS studentMenu = new StudentMenuCRS();
						studentMenu.create_menu(userId);

					} else {
						System.out.println("You have not been approved by the admin!");
						loggedin = false;
					}
					break;
				}

			} else {
				System.out.println("Invalid Credentials!");
			}
			System.out.println("-----------------------------------------------------------------------------------------\n");

		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
