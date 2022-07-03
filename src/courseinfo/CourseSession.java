package courseinfo;
import java.time.LocalDate;
import java.util.ArrayList;

import studentinfo.Student;

/**
 * Represents a course session offered in a single-semester by an university.
 * 
 * @author Alejandro Costa
 *
 */
public class CourseSession {
	
	static final String ROSTER_REPORT_HEADER = "List of students enrolled in this course\n";
	static final String ROSTER_REPORT_FOOTER = "Number of students enrolled in this course: ";

	private String department;
	private String number;
	
	private ArrayList<Student> students = new ArrayList<>();
	
	private LocalDate startDate;
	
	/**
	 * Constructs a CourseSession holding information on the department identification, course number, and a specific initial date for the course
	 * 
	 * @param department the identification of the department responsible for the CourseSession
	 * @param number the number identification of the course
	 * @param startDate the date on which the course begins
	 */
	public CourseSession(String department, String number, LocalDate startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudents() {
		return students.size();
	}
	
	public void enroll(Student student) {
		students.add(student);
	}

	public Student get(int index) {
		return students.get(index);
	}

	public LocalDate getEndDate() {
		return startDate.plusWeeks(16L);
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public String getRosterReport() {
		
		StringBuilder buffer = new StringBuilder();
		buffer.append(ROSTER_REPORT_HEADER);
		
		Student student = this.get(0);
		buffer.append(student.getName());
		buffer.append("\n");
		
		student = this.get(1);
		buffer.append(student.getName());
		buffer.append("\n");
		
		buffer.append(ROSTER_REPORT_FOOTER + this.getNumberOfStudents() + "\n");
		
		return buffer.toString();
	}
	
}
