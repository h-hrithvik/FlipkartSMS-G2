/**
 * 
 */
package com.flipkart.bean;

/**
 * @author JEDI-02
 *	Course Class
 */
public class Course {

	private String courseId;
	private String courseName;
	private String instructorId;
	private int seats = 10;

	public Course() {
		super();
	}

	/**
	 * Constructor to instantiate Course object
	 * @param courseId
	 * @param courseName
	 * @param instructorId
	 * @param seats
	 */
	public Course(String courseId, String courseName, String instructorId, int seats) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructorId = instructorId;
		this.seats = seats;
	}

	/**
	 * Getters Setters Methods
	 *
	 */
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
