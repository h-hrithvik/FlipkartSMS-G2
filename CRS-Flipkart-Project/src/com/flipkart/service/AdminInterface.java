/**
 * 
 */
package com.flipkart.service;
import java.util.List;

import com.flipkart.bean.*;
/**
 * @author arya_
 *
 */
public interface AdminInterface {
	
	public void removeCourse(String courseId, List<Course>coursecatalog);
	public void addCourse(Course course,List<Course>courseCatalog);
	public boolean approveStudent(String studentId);
	public void addProfessor(Professor professor);
	public void generateReport(ReportCard reportCard);	
}
