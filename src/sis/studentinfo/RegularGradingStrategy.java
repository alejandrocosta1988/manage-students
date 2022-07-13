package sis.studentinfo;

public class RegularGradingStrategy extends BasicGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade grade) {
		return basicGradePointsFor(grade);
	}

}
