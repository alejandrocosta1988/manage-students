package sis.courseinfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sis.studentinfo.Student;

public abstract class Session implements Comparable<Session>, Iterable<Student> {

	private String department;
	private String number;
	
	private int numberOfCredits = 0;
	
	private List<Student> students = new ArrayList<>();
	
	private LocalDate startDate;
	
	Session(String department, String number, LocalDate startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}

	public Student get(int index) {
		return students.get(index);
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
	
	abstract long getSessionLength();
	
	public LocalDate getEndDate() {
		return startDate.plusWeeks(getSessionLength());
	}
	
	public double averageGpaForPartTimeStudents() {
		double total = 0d;
		int numberOfPartTimers = 0;
		for (Student student : students) {
			if (student.isFullTime()) {
				continue;
			}
			total += student.getGpa();
			numberOfPartTimers++;
		}
		if (numberOfPartTimers == 0) return 0d;
		return total / numberOfPartTimers;
	}
	
	@Override
	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0) {
			compare = this.getNumber().compareTo(that.getNumber());
		}
		return compare;
	}
	
	public Iterator<Student> iterator() {
		return students.iterator();
	}

}
