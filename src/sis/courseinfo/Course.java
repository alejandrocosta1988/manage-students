package sis.courseinfo;

public class Course {
	
	private String department;
	private String number;
	
	public Course(String departmentName, String courseNumber) {
		department = departmentName;
		number = courseNumber;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

}
