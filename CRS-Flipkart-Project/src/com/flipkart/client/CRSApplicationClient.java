
package com.flipkart.client;

import java.util.Scanner;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loggedIn = false;
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

	private static void registerStudent() {
		Scanner sc = new Scanner(System.in);

		String userId, name, password, address, branch, mobileNumber, rollNumber;

		try {
			// input all the student details
			System.out.println("---------------Student Registration-------------");
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

	private static void loginUser() {
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
			System.out.println(loggedin);
			System.out.println("post login");
			// 2 cases
			// true->role->student->approved
			if (loggedin) {
				String role = userInterface.getRole(userId);
//				Role userRole = Role.stringToName(role);
				RoleConstants userRole = RoleConstants.stringToName("ADMIN");
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
//				case STUDENT:
//					StudentInterface studentInterface = new StudentOperation();
//					String studentId = studentInterface.getStudentId(userId);
//					boolean isApproved = studentInterface.checkIsVerified(studentId);
//					if (isApproved) {
//						System.out.println( " Login Successful");
//						StudentClient studentMenu = new StudentClient();
//						studentMenu.create_menu(studentId);
//
//					} else {
//						System.out.println("Failed to login, you have not been approved by the administration!");
//						loggedin = false;
//					}
//					break;
				}

			} else {
				System.out.println("Invalid Credentials!");
			}

		} catch (UserNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void printMenu() {
		System.out.println("1---> Signup");
		System.out.println("2---> Login ");
		System.out.println("4---> Exit");
		System.out.println("Enter choice");
	}

}