package com.flipkart.bean;

/**
 * 
 * @author JEDI-02
 * Class for storing details of course Student has taken
 * 
 */
public class EnrolledStudent {
	private String courseId;
	private String courseName;
	private String studentId;
	
	/**
	 * Parameterized constructor
	 * @param courseCode
	 * @param courseName
	 * @param studentId
	 */
	public EnrolledStudent(String courseId, String courseName, String studentId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.studentId = studentId;
	}
	
	/**
	 * Method to get Course Code
	 * @return Course Code
	 */
	public String getCourseId() {
		return courseId;
	}
	
	/**
	 * Method to set Course Code
	 * @param courseCode: course code 
	 */
	public void setCourseId(String courseCode) {
		this.courseId = courseCode;
	}
	
	/**
	 * Method to get Course Name
	 * @return Course Name: course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Method to set Course Name
	 * @param courseName: course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Method to get Student Id of student enrolled in the course
	 * @return Student Id: student id
	 */
	public String getStudentId() {
		return studentId;
	}
	
	/**
	 * Method to set Student Id of student enrolled in the course
	 * @param studentId
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
}