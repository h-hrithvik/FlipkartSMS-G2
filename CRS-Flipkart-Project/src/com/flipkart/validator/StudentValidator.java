/**
 * 
 */
package com.flipkart.validator;


import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseLimitReachedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
/**
 * @author lenovo
 *
 */

public class StudentValidator {
	
	/**
	 * Method to validate if student is already registered for this particular course (courseCode) or not 
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList  
	 * @return Student Registration Status
	 * @throws CourseNotFoundException
	 */
	public static boolean isRegistered(String courseCode,int studentId,ArrayList<Course>registeredCourseList) throws CourseNotFoundException
	{
		for(Course course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				return true; 
			}
		}
		
		return false;
	}
	
	
	/**
	 * Method to validate if couseCode is valid or not
	 * @param courseCode
	 * @param availableCourseList
	 * @return couseCode is valid or not
	 */
	public static boolean isValidCourseCode(String courseId,ArrayList<Course>availableCourseList) 
	{
		for(Course course : availableCourseList)
		{
			if(courseId.equalsIgnoreCase(course.getCourseId())) 
			{
				return true; 
			}
		}
		
		return false;
	
	}

}
