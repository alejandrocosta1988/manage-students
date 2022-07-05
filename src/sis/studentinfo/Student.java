package sis.studentinfo;

public class Student {
	
	private String name;
	
	private int credits;

	public Student(String name) {
		this.name = name;
		this.credits = 0;
	}

	public String getName() {
		return name;
	}

	public boolean isFullTime() {
		return false;
	}

	public Object getCredits() {
		return this.credits;
	}

	public void addCredits(int numberOfCredits) {
		this.credits = this.credits + numberOfCredits;
	}
	
}
