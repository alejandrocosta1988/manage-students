package sis.studentinfo;

import sis.studentinfo.Student.Grade;

public class BasicGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Grade grade) {
		return grade.getPoints();
	}
	
}
