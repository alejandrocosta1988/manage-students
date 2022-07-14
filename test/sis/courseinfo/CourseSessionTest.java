package sis.courseinfo;
import java.time.LocalDate;

import junit.framework.TestCase;
import sis.studentinfo.Student;

public class CourseSessionTest extends SessionTest {
	
	@Override
	protected Session createSession(String department, String number, LocalDate startDate) {
		return CourseSession.create(department, number, startDate);
	}
	
	public void testCourseSessionsLastSixteenWeeks() {
		LocalDate startDate = LocalDate.of(2003, 1, 6);
		Session session = createSession("ENGL", "200", startDate);
		LocalDate sixteenWeeksOut = startDate.plusWeeks(16L);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", LocalDate.now());
		assertEquals(1, CourseSession.getCount());
		createSession("", "", LocalDate.now());
		assertEquals(2, CourseSession.getCount());
		
	}
	
}
