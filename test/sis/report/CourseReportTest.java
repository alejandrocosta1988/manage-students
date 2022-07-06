package sis.report;

import static sis.report.Report.NEWLINE;

import java.time.LocalDate;
import java.util.ArrayList;

import junit.framework.TestCase;
import sis.courseinfo.CourseSession;

public class CourseReportTest extends TestCase {

	public void testReport() {
		final LocalDate date = LocalDate.now();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create("ENGL", "101", date));
		report.add(CourseSession.create("CZEC", "200", date));
		report.add(CourseSession.create("ITAL", "410", date));
		
		assertEquals(
				"CZEC 200" + NEWLINE +
				"ENGL 101" + NEWLINE +
				"ITAL 410" + NEWLINE, 
				report.text());
		
	}
	
}
