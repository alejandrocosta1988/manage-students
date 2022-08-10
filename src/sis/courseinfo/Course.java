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
	
	@Override
	public boolean equals(Object object) {
		if (object == null)
			return false;
		Course that = (Course)object;
		return this.department.equals(that.department) && this.number.equals(that.number);
	}

}
