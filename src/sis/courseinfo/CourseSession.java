package sis.courseinfo;
import java.time.LocalDate;
import java.util.ArrayList;

import sis.studentinfo.Student;

/**
 * Represents a course session offered in a single-semester by an university.
 * 
 * @author Alejandro Costa 
 *
 */
public class CourseSession implements Comparable<CourseSession> {
	
	private static int count;
	
	private String department;
	private String number;
	
	private int numberOfCredits;
	
	private ArrayList<Student> students = new ArrayList<>();
	
	private LocalDate startDate;
	
	/**
	 * Constructs a CourseSession holding information on the department identification, course number, and a specific initial date for the course
	 * 
	 * @param department the identification of the department responsible for the CourseSession
	 * @param number the number identification of the course
	 * @param startDate the date on which the course begins
	 */
	protected CourseSession(String department, String number, LocalDate startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	public static CourseSession create(String department, String number, LocalDate startDate) {
		incrementCount();
		return new CourseSession(department, number, startDate);
	}

	private static void incrementCount() {
		++count;
	}

	public static int getCount() {
		return count;
	}
	
	public static void resetCount() {
		count = 0;
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
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public Student get(int index) {
		return students.get(index);
	}

	public LocalDate getEndDate() {
		return getStartDate().plusWeeks(16L);
	}

	protected LocalDate getStartDate() {
		return startDate;
	}

	public ArrayList<Student> getAllStudents() {
		return this.students;
	}
	
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public int compareTo(CourseSession that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;
	}
	
}
