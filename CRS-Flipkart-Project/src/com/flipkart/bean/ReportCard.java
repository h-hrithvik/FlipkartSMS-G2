/**
 * 
 */
package com.flipkart.bean;

public class ReportCard {
	private String studentId;
	private int semester;
	private float CPI;

	public ReportCard() {
		super();
	}

	public ReportCard(String studentId, int sem, float CPI) {
		super();
		this.studentId = studentId;
		this.semester = sem;
		this.CPI = CPI;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	@Override
	public String toString() {
		return "Grade [studentId=" + studentId + ", sem=" + semester + ", CPI=" + CPI + "]";
	}

}
