import java.time.LocalDate;
import java.util.ArrayList;

import studentinfo.Student;

public class CourseSession {

	private String department;
	private String number;
	
	private ArrayList<Student> students = new ArrayList<>();
	
	private LocalDate startDate;
	
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
	
}
