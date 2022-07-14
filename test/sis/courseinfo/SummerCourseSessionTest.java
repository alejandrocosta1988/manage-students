package sis.courseinfo;

import java.time.LocalDate;

import org.junit.Test;

import junit.framework.TestCase;

public class SummerCourseSessionTest extends SessionTest {

	@Test
	public void testSummerCourseSessionsLastEightWeeks() {
		LocalDate startDate = LocalDate.of(2022, 6, 9);
		Session session = SummerCourseSession.create("ENGL", "200", startDate);
		LocalDate eightWeeksOut = startDate.plusWeeks(8L);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

	@Override
	protected Session createSession(String department, String number, LocalDate startDate) {
		return SummerCourseSession.create(department, number, startDate);
	}
	
}
