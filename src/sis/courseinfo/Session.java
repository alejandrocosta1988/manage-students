package sis.courseinfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sis.studentinfo.Student;

public abstract class Session implements Comparable<Session>, Iterable<Student>, Serializable {

	private static final long serialVersionUID = 1L;

	private Course course;
	
	private URL url;
	
	private int numberOfCredits = 0;
	
	private transient List<Student> students = new ArrayList<>(); //transient marks the list as to be skipped during serialization
	
	private LocalDate startDate;
	
	Session(Course course, LocalDate startDate) {
		this.course = course;
		this.startDate = startDate;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	int getNumberOfCredits() {
		return numberOfCredits;
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
//		e.printStackTrace();
	}

	public URL getUrl() {
		return url;
	}
	
	private void writeObject(ObjectOutputStream output) throws IOException {
		output.defaultWriteObject();
		output.writeInt(students.size());
		for (Student student : students)
			output.writeObject(student.getLastName()); //the last name is used as the student identifier
	}
	
	private void readObject(ObjectInputStream input) throws Exception {
		input.defaultReadObject();
		students = new ArrayList<Student>();
		int size = input.readInt();
		for (int i = 0; i < size; i++) {
			String lastName = (String)input.readObject();
			students.add(Student.findByLastName(lastName));
		}
			
	}

}
