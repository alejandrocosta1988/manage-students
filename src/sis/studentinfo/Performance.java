package sis.studentinfo;

public class Performance {

	private int[] tests = {};
	
	public void setNumberOfTests(int numberOfTests) {
		tests = new int[numberOfTests];
	}

	public void set(int testNumber, int score) {
		tests[testNumber] = score;
	}
	
	public int get(int testNumber) {
		return tests[testNumber];
	}

	public double average() {
		double total = 0d;
		if (tests.length == 0)
			return 0.0;
		for (int score : tests)
			total += score;
		return total / tests.length;
	}

	//varargs declaration
	public void setScores(int... scores) {
		tests = scores;
	}

}
