package sis.courseinfo;

import java.time.LocalDate;

import org.junit.Test;

public class SummerCourseSessionTest extends SessionTest {

	@Test
	public void testSummerCourseSessionsLastEightWeeks() {
		LocalDate startDate = LocalDate.of(2022, 6, 9);
		Session session = createSession(new Course("ENGL", "200"), startDate);
		LocalDate eightWeeksOut = startDate.plusWeeks(8L);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

	@Override
	protected Session createSession(Course course, LocalDate startDate) {
		return SummerCourseSession.create(course, startDate);
	}
	
}
