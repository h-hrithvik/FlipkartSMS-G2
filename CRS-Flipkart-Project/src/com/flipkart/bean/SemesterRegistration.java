/**
 * 
 */
package com.flipkart.bean;

/**
 * @author arya_
 *
 */
public class SemesterRegistration {
	private RegisteredCourses coursesAdded[];
	private int sem;
	private String studentId;
	public RegisteredCourses[] getCoursesAdded() {
		return coursesAdded;
	}
	public void setCoursesAdded(RegisteredCourses[] coursesAdded) {
		this.coursesAdded = coursesAdded;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
