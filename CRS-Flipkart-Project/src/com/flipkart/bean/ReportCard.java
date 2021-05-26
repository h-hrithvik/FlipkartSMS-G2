/**
 * 
 */
package com.flipkart.bean;

import java.util.HashMap;

/**
 * @author JEDI-02
 * Class to implement Report Card
 *
 */
public class ReportCard {
	private String studentId;
	private HashMap<String, String> grades = new HashMap<String, String>();
	private int semester;
	private float CPI;

	/**
	 * Constructors to instantiate a report card object
	 */
	public ReportCard() {
		super();
	}

	public ReportCard(String studentId, HashMap<String, String> grades, int sem, float CPI) {
		super();
		this.studentId = studentId;
		this.grades = grades;
		this.semester = sem;
		this.CPI = CPI;
	}

	/**
	 * Getter Setters for the Report Card
	 *
	 */
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public HashMap<String, String> getGrades() {
		return grades;
	}

	public void setGrades(HashMap<String, String> grades) {
		this.grades = grades;
	}

	public int getSem() {
		return semester;
	}

	public void setSem(int sem) {
		this.semester = sem;
	}

	public float getCPI() {
		return CPI;
	}

	public void setCPI(float CPI) {
		this.CPI = CPI;
	}

	/**
	 * Method to Convert professor Id to string
	 * @return ID as string value
	 */
	@Override
	public String toString() {
		return "Grade [studentId=" + studentId + ", grades=" + grades + ", sem=" + semester + ", CPI=" + CPI + "]";
	}

}
