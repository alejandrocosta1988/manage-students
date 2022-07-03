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
		buffer.append(ROSTER_REPORT_HEADER);
		buffer.append(writeNameOfStudentsInBuffer());
		buffer.append(ROSTER_REPORT_FOOTER + session.getNumberOfStudents() + NEWLINE);
		return buffer.toString();
	}
	
	private String writeNameOfStudentsInBuffer() {
		StringBuilder buffer = new StringBuilder();
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
		return buffer.toString();
	}
	
}
