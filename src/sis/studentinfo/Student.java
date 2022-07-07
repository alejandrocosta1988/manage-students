package sis.studentinfo;

import java.util.ArrayList;

public class Student {
	
	enum Grade { A, B, C, D, F };
	
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

	//Colorado - CO
	public static final String IN_STATE = "CO";
	
	private String name;
	private String state = "";
	
	private int credits;
	
	private ArrayList<Grade> grades = new ArrayList<>();

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
		for (Grade grade : grades) {
			total += convertToGradePoints(grade);
		}
		return total / grades.size();
	}
	
	private double convertToGradePoints(Grade grade) {
		if (grade == Grade.A) return 4.0;
		if (grade == Grade.B) return 3.0;
		if(grade == Grade.C) return 2.0;
		if (grade == Grade.D) return 1.0;
		return 0.0;
	}

	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	
}
