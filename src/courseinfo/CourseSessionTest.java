package courseinfo;
import java.time.LocalDate;

import junit.framework.TestCase;
import studentinfo.Student;

public class CourseSessionTest extends TestCase {

	private CourseSession session;
	private LocalDate startDate;
	
	public void setUp() {
		startDate = LocalDate.of(2022, 8, 15);
		session = new CourseSession("ENGL", "101", startDate);
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
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));

		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
		
	}
	
	public void testCourseDates() {
		
		LocalDate sixteenWeeksOut = startDate.plusWeeks(16L);
		assertEquals(sixteenWeeksOut, session.getEndDate());
		
	}
	
	public void testRosterReport() {
		
		session.enroll(new Student("Aba Ada"));
		session.enroll(new Student("Rugh Bull"));
		
		String rosterReport = session.getRosterReport();
		
		assertEquals(
				CourseSession.ROSTER_REPORT_HEADER +
				"Aba Ada" + CourseSession.NEWLINE +
				"Rugh Bull" + CourseSession.NEWLINE +
				CourseSession.ROSTER_REPORT_FOOTER +
				"2" + CourseSession.NEWLINE, 
				rosterReport);
		
	}
	
}
