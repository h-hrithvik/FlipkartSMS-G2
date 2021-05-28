/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;
/**
 * @author hp
 *
 */
public interface ProfessorDaoInterface {
	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, professor id of the professor
	 * @return get the courses offered by the professor.
	 */
	public List<Course> getCoursesByProfessor(String userId);
	
	
	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	public List<EnrolledStudent> getStudents(String professorId);
	
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public boolean addGrade(String studentId,String courseId,int semester,String grade);


}
