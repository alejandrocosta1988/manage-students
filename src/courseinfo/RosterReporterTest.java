package courseinfo;

import java.time.LocalDate;

import junit.framework.TestCase;
import studentinfo.Student;

public class RosterReporterTest extends TestCase {
	
	public void testRosterReport() {
		
		CourseSession session = new CourseSession("ENGL", "101", LocalDate.of(2022, 7, 15));
		session.enroll(new Student("Cal Bins"));
		session.enroll(new Student("Lisa Barnes"));
		session.enroll(new Student("Lis Barnes"));
		
		String rosterReport = new RosterReporter(session).getReport();
		
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER +
				"Cal Bins" + RosterReporter.NEWLINE +
				"Lisa Barnes" + RosterReporter.NEWLINE +
				"Lis Barnes" + RosterReporter.NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER +
				"3" + RosterReporter.NEWLINE,
				rosterReport);
	}

}
