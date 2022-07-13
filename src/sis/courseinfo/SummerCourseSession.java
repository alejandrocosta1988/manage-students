package sis.courseinfo;

import java.time.LocalDate;

public class SummerCourseSession extends CourseSession {
	
	private SummerCourseSession(String department, String number, LocalDate startDate) {
		super(department, number, startDate);
	}
	
	public static SummerCourseSession create(String department, String number, LocalDate startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	
	@Override
	public LocalDate getEndDate() {
		return getStartDate().plusWeeks(8L);
	}
	
}
