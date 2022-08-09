package sis.courseinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sis.studentinfo.Student;

public abstract class Session implements Comparable<Session>, Iterable<Student> {

	private Course course;
	
	private URL url;
	
	private int numberOfCredits = 0;
	
	private List<Student> students = new ArrayList<>();
	
	private LocalDate startDate;
	
	Session(Course course, LocalDate startDate) {
		this.course = course;
		this.startDate = startDate;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getDepartment() {
		return course.getDepartment();
	}

	public String getNumber() {
		return course.getNumber();
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

	public void setUrl(String url) throws SessionException {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			log(e);
			throw new SessionException(e);
		}
	}
	
	private void log(Exception e) {
		e.printStackTrace();
	}

	public URL getUrl() {
		return url;
	}

}
