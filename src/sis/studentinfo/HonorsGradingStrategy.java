package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade grade) {
		int points = basicGradePointsFor(grade);
		if (points > 0) {
			++points;
		}
		return points;
	}
	
}