/**
 * 
 */
package com.flipkart.client;
import java.util.Scanner;

import com.flipkart.service.AdminOperation;
import com.flipkart.service.AdminInterface;
/**
 * @author arya_
 *
 */
public class AdminClient {

	public void createMenu(){
		
		AdminInterface adminObj =new AdminOperation();
		Scanner scanner = new Scanner(System.in);
		int in=0;
		while(in!=5) {
			
			System.out.println("ADMIN MENU");
			System.out.println("1. Add Course to catalog");
			System.out.println("2. Delete Course from catalog");
			System.out.println("3. Approve Students");
			System.out.println("4. Add Professor");
			System.out.println("5. Generate Report Card");
			System.out.println("6. Exit Admin Menu");
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
				returnToLogin();
				break;
				
			default:
				System.out.println("Invalid Choice");
			}
		}
		scanner.close();
	}
	private void addCourse()
	{
			
	}
	private void deleteCourse()
	{
			
	}
	private void approveStudent()
	{
			
	}
	private void addProfessor()
	{
			
	}
	private void returnToLogin()
	{
		
	}
	private void generateReport()
	{
		
	}
}
