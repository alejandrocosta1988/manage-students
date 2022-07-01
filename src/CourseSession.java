import java.util.ArrayList;

import studentinfo.Student;

public class CourseSession {

	private String department;
	private String number;
	
	private ArrayList<Student> students = new ArrayList<>();
	
	public CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
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
	
}
