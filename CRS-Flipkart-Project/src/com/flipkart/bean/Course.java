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
	@SuppressWarnings("unused")
	private int seats = 10;
	
	public Course() {
		super();
	}
	
	
	public Course(String courseId, String courseName, String instructorId, int seats) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructorId = instructorId;
		this.seats = seats;
	}
	
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
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
