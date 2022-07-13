package sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

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
	
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

	//Colorado - CO
	public static final String IN_STATE = "CO";
	
	private String name;
	private String state = "";
	
	private int credits;
	
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	private List<Grade> grades = new ArrayList<>();

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
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
}
