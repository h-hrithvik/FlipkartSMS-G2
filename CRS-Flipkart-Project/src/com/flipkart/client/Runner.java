/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.exception.StudentNotRegisteredException;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;

public class Runner {

	StudentOperation studentOperation = new StudentOperation();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean loggedIn = false;
		printMenu();
		int Input=sc.nextInt();
		
		while(Input!=4 && loggedIn)
		{
			switch(Input)
			{	
				case 1:
					registerStudent();
					break;
				case 2:
					loginUser();
					break;	
				case 3:
					updatePassword();
					break;
				default:
					System.out.println("Enter a valid input");
			}
			printMenu();
			Input=sc.nextInt();
		}
		sc.close();
	}
	
	private static void updatePassword() {

	}

	private static void registerStudent() {
		Scanner sc=new Scanner(System.in);

		String userId,name,password,address,country,branchName, mobileNumber;
		int genderV, batch;
		try
		{
			//input all the student details
			System.out.println("---------------Student Registration-------------");
			System.out.println("Name:");
			name=sc.nextLine();
			System.out.println("Email:");
			userId=sc.next();
			System.out.println("Password:");
			password=sc.next();
			System.out.println("Mobile Number:");
			mobileNumber=sc.next();
			System.out.println("Branch:");
			branchName=sc.nextLine();
			System.out.println("Batch:");
			batch=sc.nextInt();
			sc.nextLine();
			System.out.println("Address:");
			address=sc.nextLine();
			System.out.println("Country");
			country=sc.next();

			StudentOperation studentOperation = new StudentOperation();
			studentOperation.registerStudent(name, userId, password, batch, branchName, address, country);

		}
		catch(StudentNotRegisteredException ex)
		{
			System.out.println("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
	}

	private static void loginUser() {
		
	}

	public static void printMenu() {
		System.out.println("1---> Signup");
		System.out.println("2---> Login ");
		System.out.println("3---> Update Password");
		System.out.println("4---> Exit");
		System.out.println("Enter choice");
	}

}
