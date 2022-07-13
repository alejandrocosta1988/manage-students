package sis.courseinfo;

import java.time.LocalDate;

import org.junit.Test;

import junit.framework.TestCase;

public class SummerCourseSessionTest extends TestCase {

	@Test
	public void testEndDate() {
		LocalDate startDate = LocalDate.of(2022, 6, 9);
		CourseSession session = SummerCourseSession.create("ENGL", "200", startDate);
		LocalDate eightWeeksOut = startDate.plusWeeks(8L);
		assertEquals(eightWeeksOut, session.getEndDate());
	}
	
}
