package sis.report;

import java.time.LocalDate;

import junit.framework.TestCase;
import sis.courseinfo.CourseSession;

import static sis.report.Report.NEWLINE;

public class CourseReportTest extends TestCase {

	public void testReport() {
		final LocalDate date = LocalDate.now();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create("ENGL", "101", date));
		report.add(CourseSession.create("CZEC", "200", date));
		report.add(CourseSession.create("ITAL", "410", date));
		
		assertEquals(
				"ENGL 101" + NEWLINE +
				"CZEC 200" + NEWLINE +
				"ITAL 410" + NEWLINE, 
				report.text());
		
	}
	
}
