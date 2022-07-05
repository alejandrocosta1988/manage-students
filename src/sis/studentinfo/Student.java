package sis.studentinfo;

public class Student {
	
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;

	//Colorado - CO
	public static final String IN_STATE = "CO";
	
	private String name;
	private String state = "";
	
	private int credits;

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
	
}
