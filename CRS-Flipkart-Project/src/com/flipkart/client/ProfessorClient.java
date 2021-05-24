/**
 * 
 */
package com.flipkart.client;

import java.util.Scanner;

/**
 * @author hp
 *
 */
public class ProfessorClient {
	
	public void professorMenu(String professorId)
	{
		Scanner sc=new Scanner(System.in);
		
		int in;
		in=sc.nextInt();
		while(in!=4)
		{
			System.out.println("Select Option: ");
			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Logout");
			
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
					returnToLogin();
					return;
				default:
					System.out.println("Select right option.");
			}
			in=sc.nextInt();
		}
		sc.close();
		
		
	}

	public void returnToLogin() {
		// TODO Auto-generated method stub
		
	}

	public void addGrade(String professorId) {
		// TODO Auto-generated method stub
		
	}

	public void viewStudents(String professorId) {
		// TODO Auto-generated method stub
		
	}

	public void getCourses(String professorId) {
		// TODO Auto-generated method stub
		
	}
}
