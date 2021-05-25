/**
 * 
 */
package com.flipkart.exception;

/**
 * @author lenovo
 *
 */
public class StudentNotRegisteredException extends Exception {
	
	private String studentName;
	 
	 public StudentNotRegisteredException(String studentName)
	 {
		 this.studentName=studentName;
	 }
	 
	 /**
	  * getter function for studentName
	  * @return
	  */
	 public String getStudentName()
	 {
		 return studentName;
	 }
	 
	 /**
		 * Message returned when exception is thrown
		 */
	@Override
	public String getMessage() {
			return "studentName: " + studentName + " not Registered." ;
	}

}
