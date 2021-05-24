/**
 * 
 */
package com.flipkart.bean;
import java.util.HashMap;
/**
 * @author naman
 *
 */
public class ReportCard {
	private String studentId;
	HashMap<String, String> grades = new HashMap<String, String>();
	private int sem;
	private int CPI;
	
	public ReportCard() {
		super();
	}
	public ReportCard(String studentId, HashMap<String, String> grades, int sem, int cPI) {
		super();
		this.studentId = studentId;
		this.grades = grades;
		this.sem = sem;
		CPI = cPI;
	}
	
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
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	
	public int getCPI() {
		return CPI;
	}
	public void setCPI(int cPI) {
		CPI = cPI;
	}
	@Override
	public String toString() {
		return "Grade [studentId=" + studentId + ", grades=" + grades + ", sem=" + sem + ", CPI=" + CPI + "]";
	}
	
}
