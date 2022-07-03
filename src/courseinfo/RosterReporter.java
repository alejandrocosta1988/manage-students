package courseinfo;

import studentinfo.Student;

public class RosterReporter {

	static final String NEWLINE = System.getProperty("line.separator");
	static final String ROSTER_REPORT_HEADER = "List of students enrolled in this course" + NEWLINE;
	static final String ROSTER_REPORT_FOOTER = "Number of students enrolled in this course: ";
	
	private CourseSession session;
	
	public RosterReporter(CourseSession session) {
		this.session = session;
	}
	
	public String getReport() {
		StringBuilder buffer = new StringBuilder();
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);
		return buffer.toString();
	}
	
	private void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}
	
	private void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}
	
	private void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + session.getNumberOfStudents() + NEWLINE);
	}
	
}
