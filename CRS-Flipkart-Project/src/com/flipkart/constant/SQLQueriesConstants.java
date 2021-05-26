/**
 * 
 */
package com.flipkart.constant;

/**
 * @author JEDI-02
 *
 */
public class SQLQueriesConstants {

	public static final String DELETE_COURSE_QUERY = "delete from course where courseId = ?";
	public static final String ADD_COURSE_QUERY = "insert into course(courseId, courseName, instructorId ,seats) values (?, ?, ?, ?)";
	public static final String VIEW_PENDING_ADMISSION_QUERY = "select userId, name, password, phonenumber, address, studentId from student natural join user where isVerified = 0";
	public static final String APPROVE_STUDENT_QUERY = "update student set isVerified = 1 where studentId = ?";
	public static final String ADD_USER_QUERY = "insert into user(userId, name, password, role,phonenumber, address) values (?, ?, ?, ?, ?, ?)";
	public static final String ADD_PROFESSOR_QUERY = "insert into professor(userIdf,professorId, department) values (?, ?, ?)";
	public static final String DELETE_PROFESSOR_QUERY = "delete from professor where professorId = ( ?)";
	public static final String ASSIGN_COURSE_QUERY = "update course set professorId = ? where courseCode = ?";
	public static final String VIEW_COURSE_QUERY = "select courseId, courseName, instructorId from course where courseId = ?";
	
	public static final String ADD_STUDENT="insert into student (userId,studentId,branch,isVerified) values (?,?,?,?)";
	public static final String VERIFY_CREDENTIALS="select password from user where userId = ?";
	public static final String GET_ROLE="select role from user where userId = ? ";
	public static final String IS_APPROVED="select isVerified from student where studentId = ? ";
	public static final String GET_STUDENT_ID="select studentId from student where userId = ? ";
	public static final String UPDATE_PASSWORD="update user set password=? where userId = ? ";
		
	// Student Queries
	public static final String VIEW_REGISTERED_COURSES=" select * from course inner join semesterregistration on course.courseId = semesterregistration.courseId where semesterregistration.studentId = ? and semesterregistration.semester = ?";
	public static final String VIEW_AVAILABLE_COURSES=" select * from course where courseId not in  (select courseId  from semesterregistration where studentId = ? and semester = ?) and seats > 0";
	public static final String DECREMENT_COURSE_SEATS="update course set seats = seats-1 where courseId = ? ";
	public static final String ADD_COURSE="insert into semesterregistration (studentId,courseId,semester,grade) values ( ?,?,?,? )";
	public static final String DROP_COURSE_QUERY = "delete from semesterregistration where courseId = ? AND studentId = ? and semester = ?;";
	public static final String INCREMENT_SEAT_QUERY  = "update course set seats = seats + 1 where courseId = ?;";
	public static final String VIEW_GRADE = "select course.courseId,course.courseName,semesterregistration.grade from course inner join semesterregistration on course.courseCode = semesterregistration.courseCode where semesterregistration.studentId = ? and semesterregistration.semester = ?;";	
	public static final String VIEW_REPORT_CARD = "select * from reportcard where studentId = ? and semester = ?;";	
	public static final String GET_SEATS = "select seats from course where courseId = ?;";
	public static final String INSERT_PAYMENT = "insert into payment(studentId_payment,paymentId,status,amount,notificationId,semester) values(?,?,?,?,?,?);";
	public static final String VIEW_PAYMENT = "select * from  payment where studentId_payment = ? and semester = ?;";

	public static final String GET_NOTIFICATION = "select * from payment where studentId_payment = ?;";
	public static final String ADD_GRADE="update semesterregistration set grade=? where courseId=? and studentId=? and semester = ?";
	public static final String GET_COURSES="select * from course where instructorId=?";
	public static final String GET_REGISTRATION_STATUS=" select isRegistered from student where studentId = ? ";
	public static final String GET_ENROLLED_STUDENTS="select course.courseId,course.courseName,semesterregistration.studentId,semesterregistration.semester from course inner join semesterregistration on course.courseId = semesterregistration.courseId where course.instructorId = ? order by course.courseId";
	public static final String NUMBER_OF_REGISTERED_COURSES=" select studentId from semesterregistration where studentId = ? ";
	public static final String IS_REGISTERED=" select courseId from semesterregistration where courseId=? and studentId=? and semester = ?";
	public static final String ADD_REPORT_CARD=" insert into reportcard(studentId_report , cpi,semester) values (? , ? , ?);";
	public static final String FETCH_GRADES=" select grade , courseId from semesterregistration where studentId=? and semester = ?";
	public static final String DELETE_USER_QUERY = "delete from user where userId = ( ?)";
}
