package sis.report;

import static sis.report.Report.NEWLINE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;

import junit.framework.TestCase;
import sis.courseinfo.Course;
import sis.courseinfo.CourseSession;
import sis.courseinfo.Session;
import sis.studentinfo.Student;

public class RosterReporterTest extends TestCase {
	
	private Session session;
	
	@Override
	public void setUp() {
		session = CourseSession.create(new Course("ENGL", "101"), LocalDate.of(2022, 7, 15));
		session.enroll(new Student("Cal Bins"));
		session.enroll(new Student("Lisa Barnes"));
		session.enroll(new Student("Lis Barnes"));
	}
	
	public void testRosterReport() throws IOException {
		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		assertReportContents(writer.toString());
	}
	
	private void assertReportContents(String rosterReport) {
		assertEquals(
				RosterReporter.ROSTER_REPORT_HEADER +
				"Cal Bins" + NEWLINE +
				"Lisa Barnes" + NEWLINE +
				"Lis Barnes" + NEWLINE +
				RosterReporter.ROSTER_REPORT_FOOTER +
				session.getNumberOfStudents() + NEWLINE,
				rosterReport);
	}
	
	public void testFiledReport() throws IOException {
		final String fileName = "testFiledReport.txt";
		new RosterReporter(session).writeReport(fileName);
		StringBuffer buffer = new StringBuffer();
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while((line = reader.readLine()) != null)
			buffer.append(String.format(line + "%n"));
		reader.close();
		
		assertReportContents(buffer.toString());
	}

}
