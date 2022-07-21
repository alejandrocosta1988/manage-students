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
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	private String state = "";
	
	private int credits;
	
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	private List<Grade> grades = new ArrayList<>();

	public Student(String fullName) {
		name = fullName;
		credits = 0;
		List<String> nameParts = split(fullName);
		setName(nameParts);
	}
	
	private List<String> split(String name) {
		List<String> results = new ArrayList<>();
		StringBuffer word = new StringBuffer();
		for (int index = 0; index < name.length(); index++) {
			char ch = name.charAt(index);
			if (!Character.isWhitespace(ch)) {
				word.append(ch);
			} 
			else
				if (word.length() > 0) {
					results.add(word.toString());
					word = new StringBuffer();
				}
		}
		if (word.length() > 0)
			results.add(word.toString());
		return results;
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}
	
}
