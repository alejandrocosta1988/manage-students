package sis.report;

import static sis.report.Report.NEWLINE;

import java.time.LocalDate;

import junit.framework.TestCase;
import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.courseinfo.Session;

public class CourseReportTest extends TestCase {

	public void testReport() {
		final LocalDate date = LocalDate.now();
		CourseReport report = new CourseReport();
		report.add(create("ENGL", "101", date));
		report.add(create("CZEC", "200", date));
		report.add(create("ITAL", "410", date));
		report.add(create("CZEC", "220", date));
		report.add(create("ITAL", "330", date));
		
		assertEquals(
				"CZEC 200" + NEWLINE +
				"CZEC 220" + NEWLINE +
				"ENGL 101" + NEWLINE +
				"ITAL 330" + NEWLINE + 
				"ITAL 410" + NEWLINE, 
				report.text());
		
	}
	
	private Session create(String departmentName, String number, LocalDate date) {
		return CourseSession.create(new Course(departmentName, number), date);
	}
	
}
