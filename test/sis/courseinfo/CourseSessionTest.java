package sis.courseinfo;
import java.time.LocalDate;

import junit.framework.TestCase;
import sis.studentinfo.Student;

public class CourseSessionTest extends TestCase {
	
	private static final int CREDITS = 3;

	private CourseSession session;
	private LocalDate startDate;
	
	public void setUp() {
		startDate = LocalDate.of(2022, 8, 15);
		session = createCourseSession();
	}
	
	private CourseSession createCourseSession() {
		CourseSession session = CourseSession.create("ENGL", "101", startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
	
	public void testCreate() {
		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
		
	}
	
	public void testEnrollStudents() {
		
		Student student1 = new Student("Alg Mei");
		Student student2 = new Student("Kim Jones");
		
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		session.enroll(student2);
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
		
	}
	
	public void testCourseDates() {
		
		LocalDate sixteenWeeksOut = startDate.plusWeeks(16L);
		assertEquals(sixteenWeeksOut, session.getEndDate());
		
	}
	
	public void testCount() {
		CourseSession.resetCount();
		createCourseSession();
		assertEquals(1, CourseSession.getCount());
		createCourseSession();
		assertEquals(2, CourseSession.getCount());
		
	}
	
	public void testComparable() {
		CourseSession sessionA = CourseSession.create("CMSC", "101", startDate);
		CourseSession sessionB = CourseSession.create("ENGL", "101", startDate);
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		CourseSession sessionC = CourseSession.create("CMSC", "101", startDate);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		CourseSession sessionD = CourseSession.create("CMSC", "210", startDate);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
		
	}
	
}
