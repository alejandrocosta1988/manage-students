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
			if (grade.equals("A")) total += 4;
			else if (grade.equals("B")) total += 3;
			else if(grade.equals("C")) total += 2;
			else if (grade.equals("D")) total += 1;
		}
		return total / grades.size();
	}

	public void addGrade(String grade) {
		grades.add(grade);
	}
	
}
