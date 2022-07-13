package sis.studentinfo;

import sis.studentinfo.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Grade grade) {
		return basicGradePointsFor(grade);
	}
	
	int basicGradePointsFor(Student.Grade grade) {
		switch (grade) {
			case A: return 4;
			case B: return 3;
			case C: return 2;
			case D: return 1;
			default: return 0;
		}
	}
	
}
