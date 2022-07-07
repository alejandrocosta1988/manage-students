package sis.studentinfo;

import java.util.ArrayList;

public class Student {
	
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

	//Colorado - CO
	public static final String IN_STATE = "CO";
	
	private String name;
	private String state = "";
	
	private int credits;
	
	private ArrayList<String> grades = new ArrayList<>();

	public Student(String name) {
		this.name = name;
		credits = 0;
	}

	public String getName() {
		return name;
	}

	public boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	public Object getCredits() {
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
		double total = 0.0;
		if (grades.isEmpty()) {
			return total;
		}
		for (String grade : grades) {
			total += convertToGradePoints(grade);
		}
		return total / grades.size();
	}
	
	private double convertToGradePoints(String grade) {
		if (grade.equals("A")) return 4.0;
		if (grade.equals("B")) return 3.0;
		if(grade.equals("C")) return 2.0;
		if (grade.equals("D")) return 1.0;
		return 0.0;
	}

	public void addGrade(String grade) {
		grades.add(grade);
	}
	
}
