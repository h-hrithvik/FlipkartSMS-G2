/**
 * 
 */
package com.flipkart.bean;

/**
 * @author lenovo
 *
 */
public class Course {
	
	private String courseId;
	private String courseName;
	private String instructorId;
	private int seats = 10;
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	
}
