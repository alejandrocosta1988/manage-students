package sis.studentinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Student {
	
	public enum Grade { 
		A(4), 
		B(3), 
		C(2), 
		D(1), 
		F(0);
		
		private int points;
		
		Grade(int points) {
			this.points = points;
		}
		
		int getPoints() {
			return points;
		}
	
	};
	
	public static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final int MAX_NAME_PARTS = 3;
	static final String TOO_MANY_PARTS_MSG = "Student name '%s' contains more than '%d' parts.";
	final static Logger logger = Logger.getLogger(Student.class.getName());
	
	//Colorado - CO
	public static final String IN_STATE = "CO";
	
	private String name;
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	private String state = "";
	private String id;
	
	private int credits;
	
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	private List<Grade> grades = new ArrayList<>();
	private List<Integer> charges = new ArrayList<>();

	public Student(String fullName) {
		name = fullName;
		credits = 0;
		List<String> nameParts = split(fullName);
		if (nameParts.size() > MAX_NAME_PARTS) {
			String message = String.format(Student.TOO_MANY_PARTS_MSG, fullName, Student.MAX_NAME_PARTS);
			Student.logger.info(message);
			throw new StudentNameFormatException(message);
		}
		setName(nameParts);
	}
	
	private List<String> split(String fullName) {
		return new ArrayList<>(Arrays.asList(fullName.split(" ")));
	}
	
	private void setName(List<String> nameParts) {
		lastName = removeLast(nameParts);
		String name = removeLast(nameParts);
		if (nameParts.isEmpty()) {
			firstName = name;
		} else {
			middleName = name;
			firstName = removeLast(nameParts);
		}
	}
	
	private String removeLast(List<String> list) {
		if (list.isEmpty()) {
			return "";
		}
		return list.remove(list.size() - 1);
	}

	public String getName() {
		return name;
	}

	public boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public int getCredits() {
		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public boolean isInState() {
		return state.equals(IN_STATE);
	}

	void setState(String state) {
		this.state = state.toUpperCase();
	}

	public double getGpa() {
		Student.logger.fine("Begin getGpa " + System.currentTimeMillis());
		double total = 0.0;
		if (grades.isEmpty()) {
			return total;
		}
		for (Grade grade : grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}
		Student.logger.fine("End getGpa " + System.currentTimeMillis());
		return total / grades.size();
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void addCharge(int charge) {
		charges.add(charge);
	}

	public int totalCharges() {
		int total = 0;
		for (int charge : charges) {
			total += charge;
		}
		return total;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public static Student findByLastName(String lastName) {
		return new Student(lastName);
	}
	
}
