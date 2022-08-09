package sis.courseinfo;

import java.time.LocalDate;

public class SummerCourseSession extends Session {
	
	public static SummerCourseSession create(Course course, LocalDate startDate) {
		return new SummerCourseSession(course, startDate);
	}
	
	private SummerCourseSession(Course course, LocalDate startDate) {
		super(course, startDate);
	}
	
	@Override
	protected long getSessionLength() {
		return 8L;
	}
	
}
