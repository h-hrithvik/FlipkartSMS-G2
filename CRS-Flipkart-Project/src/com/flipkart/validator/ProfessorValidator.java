package com.flipkart.validator;

import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;


/**
 * 
 * @author JEDI-02
 * Class for Professor Validator
 * 
 */
public class ProfessorValidator {
	
	/**
	 * Method to check if Student exist in the database
	 * @param students: list of students in the database
	 * @param studentId: current student
	 * @return true, if student is valid. else, false.
	 */
	public static boolean isValidEntry(List<EnrolledStudent> students,String studentId,String courseCode,int semester)
	{
		boolean result=false;
		//check if student exist in ihe students list
		for(EnrolledStudent student : students)
		{
			//role.equalsIgnoreCase("ADMIN")
			if(student.getStudentId().equalsIgnoreCase(studentId) && student.getCourseId().equalsIgnoreCase(courseCode) && student.getSemester()==semester)
				result=true;
				
		}
		return result;
	}
	

}