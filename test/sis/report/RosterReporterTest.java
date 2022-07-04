package sis.report;

import java.time.LocalDate;

import junit.framework.TestCase;
import sis.courseinfo.CourseSession;
import sis.studentinfo.Student;

import static sis.report.Report.NEWLINE;

public class RosterReporterTest extends TestCase {
	
	public void testRosterReport() {
		
		CourseSession session = new CourseSession("ENGL", "101", LocalDate.of(2022, 7, 15));
		session.enroll(new Student("Cal Bins"));
		session.enroll(new Student("Lisa Barnes"));
		session.enroll(new Student("Lis Barnes"));
		
		String rosterReport = new RosterReporter(session).getReport();
		
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER +
				"Cal Bins" + NEWLINE +
				"Lisa Barnes" + NEWLINE +
				"Lis Barnes" + NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER +
				"3" + NEWLINE,
				rosterReport);
	}

}
