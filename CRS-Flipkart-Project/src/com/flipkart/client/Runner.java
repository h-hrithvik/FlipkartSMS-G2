/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

public class Runner {

	/**
	 * @param args
	 */
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
		// TODO Auto-generated method stub
		
	}

	private static void registerStudent() {
		// TODO Auto-generated method stub
		
	}

	private static void loginUser() {
		// TODO Auto-generated method stub
		
	}

	public static void printMenu() {
		System.out.println("1---> Signup");
		System.out.println("2---> Login ");
		System.out.println("3-----> Update password");
		System.out.println("4------> Exit");
		System.out.println("Enter choice");
	}

}
