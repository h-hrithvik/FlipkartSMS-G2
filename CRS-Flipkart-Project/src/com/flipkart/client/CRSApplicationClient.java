
package com.flipkart.client;

import java.util.Scanner;

import javax.management.relation.Role;

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

public class CRSApplicationClient {

	public static void main(String[] args) throws StudentNotRegisteredException {
		Scanner sc = new Scanner(System.in);
		boolean loggedIn = false;
		System.out.println("************************************************************");
		System.out.println("*******   WELCOME to Course Registration System!!!  ********");
		System.out.println("************************************************************");

		printMenu();
		int Input=sc.nextInt();
		
		while(Input!=4)
		{
			switch(Input)
			{	
				case 1:
					registerStudent();
					break;
				case 2:
					loginUser();
					break;
				default:
					System.out.println("Enter a valid input");
			}
			printMenu();
			Input = sc.nextInt();
		}
		sc.close();
	}

	public static void printMenu() {
		System.out.println("1. Signup");
		System.out.println("2. Login ");
		System.out.println("3. Exit");
		System.out.println("Please enter your choice");
	}
	
	private static void registerStudent() {
		Scanner sc = new Scanner(System.in);

		String userId, name, password, address, branch, mobileNumber, rollNumber;

		try {
			// input all the student details
			System.out.println("------------------------------------------");
			System.out.println("        STUDENT REGISTRATION");
			System.out.println("------------------------------------------");

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

		} catch (UserAlreadyExistException ex) {
			ex.getMessage();
		}
	}

	private static void loginUser() throws StudentNotRegisteredException {
		Scanner sc = new Scanner(System.in);

		String userId, password;
		try {
			System.out.println("-----------------Login------------------");
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
					System.out.println(" Login Successful");
					AdminMenuCRS adminMenu = new AdminMenuCRS();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					System.out.println(" Login Successful");
					ProfessorMenuCRS professorMenu = new ProfessorMenuCRS();
					professorMenu.professorMenu(userId);

					break;
				case STUDENT:
					StudentInterface studentInterface = new StudentOperation();
//					String studentId = studentInterface.getStudentId(userId);
//					System.out.println(userId);
					int isApproved = studentInterface.checkIsVerified(userId);
					if (isApproved == 1) {
						System.out.println( " Login Successful");
						StudentMenuCRS studentMenu = new StudentMenuCRS();
						studentMenu.create_menu(userId);

					} else {
						System.out.println("You have not been approved by the admin!!!");
						loggedin = false;
					}
					break;
				}

			} else {
				System.out.println("Invalid Credentials!");
			}

		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
