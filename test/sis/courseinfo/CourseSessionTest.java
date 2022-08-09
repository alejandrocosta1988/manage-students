package sis.courseinfo;
import java.time.LocalDate;

public class CourseSessionTest extends SessionTest {
	
	@Override
	protected Session createSession(Course course, LocalDate startDate) {
		return CourseSession.create(course, startDate);
	}
	
	public void testCourseSessionsLastSixteenWeeks() {
		LocalDate startDate = LocalDate.of(2003, 1, 6);
		Session session = createSession(createCourse(), startDate);
		LocalDate sixteenWeeksOut = startDate.plusWeeks(16L);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	private Course createCourse() {
		return new Course("ENGL", "200");
	}
	
	public void testCount() {
		CourseSession.resetCount();
		createSession(createCourse(), LocalDate.now());
		assertEquals(1, CourseSession.getCount());
		createSession(createCourse(), LocalDate.now());
		assertEquals(2, CourseSession.getCount());
		
	}
	
}
