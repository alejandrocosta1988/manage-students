package sis.studentinfo;

public class RegularGradingStrategy extends BasicGradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade grade) {
		return basicGradePointsFor(grade);
	}

}
