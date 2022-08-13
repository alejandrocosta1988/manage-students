package sis.report;

import static sis.report.Report.NEWLINE;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;

import junit.framework.TestCase;
import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.studentinfo.Student;

public class RosterReporterTest extends TestCase {
	
	public void testRosterReport() throws IOException {
		
		CourseSession session = CourseSession.create(new Course("ENGL", "101"), LocalDate.of(2022, 7, 15));
		session.enroll(new Student("Cal Bins"));
		session.enroll(new Student("Lisa Barnes"));
		session.enroll(new Student("Lis Barnes"));
		
		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		String rosterReport = writer.toString();
		
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
