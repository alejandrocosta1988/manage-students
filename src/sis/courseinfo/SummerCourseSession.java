package sis.courseinfo;

import java.time.LocalDate;

public class SummerCourseSession extends Session {
	
	public static SummerCourseSession create(String department, String number, LocalDate startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	
	private SummerCourseSession(String department, String number, LocalDate startDate) {
		super(department, number, startDate);
	}
	
	@Override
	protected long getSessionLength() {
		return 8L;
	}
	
}
