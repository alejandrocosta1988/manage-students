package sis.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import sis.courseinfo.Session;
import sis.studentinfo.Student;

public class RosterReporter {

	static final String ROSTER_REPORT_HEADER = "List of students enrolled in this course" + Report.NEWLINE;
	static final String ROSTER_REPORT_FOOTER = "Number of students enrolled in this course: ";
	
	private Session session;
	private Writer writer;
	
	public RosterReporter(Session session) {
		this.session = session;
	}
	
	void writeReport(Writer writer) throws IOException {
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}
	
	private void writeHeader() throws IOException {
		writer.write(ROSTER_REPORT_HEADER);
	}
	
	private void writeBody() throws IOException {
		for (Student student : session.getAllStudents()) {
			writer.write(student.getName());
			writer.write(Report.NEWLINE);
		}
	}
	
	private void writeFooter() throws IOException {
		writer.write(ROSTER_REPORT_FOOTER + session.getNumberOfStudents() + Report.NEWLINE);
	}
	
	void writeReport(String fileName) throws IOException {
		Writer bufferedWriter = new BufferedWriter(new FileWriter(fileName));
		try {
			writeReport(bufferedWriter);
		} 
		finally {
			bufferedWriter.close();
		}
	}

}
